package karazin.scala.users.group.week1.topic

import karazin.scala.users.group.week1.topic.model.User.UserId

import java.util.UUID

// Do not forget to import custom implementation
import adt._
import model._
import services._

/*
  Desugaring examples
 */
object desugaring:
  
  /*
    Only `map`-required case
    The only internal object is changed (from `Profile` to `UserId`)
   */
  def getUserId(apiKey: String): Option[UserId] =
   for
     profile <- getUserProfile(apiKey)
   yield profile.userId
   
  def getUserIdDesugared(apiKey: String): Option[UserId] =
    getUserProfile(apiKey: String) map { profile =>
      profile.userId
    }
    
   /*
    Only `flatMap`-required case
    Pipeline execution, the one service is called after another
   */
  def getUserPosts(apiKey: String): Option[List[Post]] =
   for
     profile <- getUserProfile(apiKey)
     posts   <- getPosts(profile.userId)
   yield posts 

  def getUserPostsDesugared(apiKey: String): Option[List[Post]] =
    getUserProfile(apiKey) flatMap { profile =>
      getPosts(profile.userId)
    }

   /*
    Both `map`- and `flatMap`-required case
    Pipeline execution, the one service is called after another
    Then internal object is changed (from `List[Post]` to `Post`)
   */
  def getUserFirstPosts(apiKey: String): Option[Post] =
   for
     profile <- getUserProfile(apiKey)
     posts   <- getPosts(profile.userId)
   yield posts.head
   
  def getUserFirstPostsDesugared(apiKey: String): Option[Post] = 
    getUserProfile(apiKey) flatMap { profile =>
      getPosts(profile.userId)
    } map { posts =>
      posts.head
    }
