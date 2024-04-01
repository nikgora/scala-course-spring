package karazin.scala.users.group.week2.topic

// Do not forget to import custom implementation
import karazin.scala.users.group.week2.topic.adt.*
import karazin.scala.users.group.week2.topic.model.*
import karazin.scala.users.group.week2.topic.services.*

object program:

  // Getting view for all user's posts
  def getPostsViews(apiKey: String)(commentsFilter: List[Comment] => Boolean, 
                                    likesFilter: List[Like] => Boolean): Option[List[Option[PostView]]] = 
    for
      profile   <- getUserProfile(apiKey)
      posts     <- getPosts(profile.userId)
      postsView <- Option(posts map { post => getPostView(post)(commentsFilter, likesFilter) })
    yield postsView

  // Desugared
  def getPostsViewDesugared(apiKey: String)(commentsFilter: List[Comment] => Boolean,
                                            likesFilter: List[Like] => Boolean): Option[List[Option[PostView]]] =
    getUserProfile(apiKey) flatMap { profile =>
      getPosts(profile.userId)
    } map { posts =>
      posts map { post =>
        getComments(post.postId).withFilter(commentsFilter) flatMap { comments =>
          getLikes(post.postId).withFilter(likesFilter) flatMap { likes =>
            getShares(post.postId) map { shares =>
              PostView(post, comments, likes, shares)
            }
          }
        }
      }
    }

  // Getting view for a particular user's post
  def getPostView(post: Post)(commentsFilter: List[Comment] => Boolean, 
                              likesFilter: List[Like] => Boolean): Option[PostView] = 
    for
      comments  <- getComments(post.postId)
      if commentsFilter(comments)
      likes     <- getLikes(post.postId)
      if likesFilter(likes)
      shares    <- getShares(post.postId)
    yield PostView(post, comments, likes, shares)

  // Desugared
  def getPostViewDesugared(post: Post)(commentsFilter: List[Comment] => Boolean,
                                       likesFilter: List[Like] => Boolean): Option[PostView] =
    getComments(post.postId).withFilter(commentsFilter) flatMap { comments =>
      getLikes(post.postId).withFilter(likesFilter) flatMap { likes =>
        getShares(post.postId) map { shares =>
          PostView(post, comments, likes, shares)
        }
      }
    }
