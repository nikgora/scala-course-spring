package karazin.scala.users.group.week1.topic

// Do not forget to import custom implementation
import adt._

import model._
import services._

object program:

  // Getting view for all user's posts
  def getPostsViews(apiKey: String): Option[List[Option[PostView]]] = 
    for
      profile   <- getUserProfile(apiKey)
      posts     <- getPosts(profile.userId)
      postsView <- Option(posts map { post => getPostView(post) })
    yield postsView

  // Desugared
  def getPostsViewDesugared(apiKey: String): Option[List[Option[PostView]]] =
    getUserProfile(apiKey) flatMap { profile =>
      getPosts(profile.userId)
    } map { posts =>
      posts map { post =>
        getComments(post.postId) flatMap { comments =>
          getLikes(post.postId) flatMap { likes =>
            getShares(post.postId) map { shares =>
              PostView(post, comments, likes, shares)
            }
          }
        }
      }
    }

  // Getting view for a particular user's post
  def getPostView(post: Post): Option[PostView] = 
    for
      comments  <- getComments(post.postId)
      likes     <- getLikes(post.postId)
      shares    <- getShares(post.postId)
    yield PostView(post, comments, likes, shares)

  // Desugared
  def getPostViewDesugared(post: Post): Option[PostView] =
    getComments(post.postId) flatMap { comments =>
      getLikes(post.postId) flatMap { likes =>
        getShares(post.postId) map { shares =>
          PostView(post, comments, likes, shares)
        }
      }
    }
