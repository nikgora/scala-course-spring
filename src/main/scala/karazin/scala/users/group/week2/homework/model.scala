package karazin.scala.users.group.week2.homework

import karazin.scala.users.group.week2.homework.model.User.UserId
import karazin.scala.users.group.week2.homework.model.Post.PostId
import java.util.UUID

/*
  Consider the way to implement blog structure (getting rid of details):
  * each user has unique id
  * each post belongs to one user and has unique id
  * each comment belongs to one user (author of the comment) and commented post
  * each share belongs to one user (who shares the post) and shared post
  
  View represents gathered information due to each service could be responsible only
  for one domain 
 */
object model:
  object User:
    opaque type UserId <: UUID = UUID

    object UserId:
      def apply(userId: UUID): UserId = userId

      def generate: UserId = UserId(UUID.randomUUID())

      object UserId:
        def apply(userId: UUID): UserId = userId

        def generate: UserId = UserId(UUID.randomUUID())
  // Implement and use UserId instead of UUID
  case class UserProfile(userId: UserId)

  // Implement and use PostId instead of UUID
  object Post:
    opaque type PostId <: UUID = UUID

    object PostId:
      def apply(postId: UUID): PostId = postId

      def generate: PostId = PostId(UUID.randomUUID())
  case class Post(userId: UserId, postId: PostId)
  case class Comment(userId: UserId, postId: PostId)
  case class Like(userId: UserId, postId: PostId)
  case class Share(userId: UserId, postId: PostId)
  case class PostView(post: Post, comments: List[Comment], likes: List[Like], shares: List[Share])
  