import java.time.*

fun main(args: Array<String>) {

}

data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val date: LocalDate = LocalDate.now(),
    var text: String = "empty",
    val friendsOnly: Boolean = false,
    val postType: PostType = PostType.POST,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val views: Int = 0,
    val isFavorite: Boolean = false,
    var comments: Comments = Comments(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts()
) {
    enum class PostType {
        POST, COPY, REPLY, POSTPONE, SUGGEST
    }

    class Comments(
        count: Int = 0,
        canPost: Boolean = true,
        groupsCanPostType: Boolean = true,
        canClose: Boolean = true,
        canOpen: Boolean = true
    )

    class Likes(
        val count: Int = 0,
        val userLikes: Boolean = true,
        val canLike: Boolean = true,
        val canPublish: Boolean = true
    )

    class Reposts(
        val count: Int = 0,
        val userReposted: Boolean = false
    )
}

object WallService {
    private var posts = emptyArray<Post>() //массив хранения постов
    private var uniqId: Int = 0 //уникальный айди поста
    fun add(post: Post): Post { // добавляем пост в массив с присвоением уникального айди и начальной записи
        uniqId ++
        post.id = uniqId
        post.text = "Запись #$uniqId"
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean { //Обновляем пост в массиве
        var update: Boolean = false
        for (oldPost in posts) {
            if (oldPost.id == post.id) {
                posts[oldPost.id-1] = post.copy()
                update = true
            }
        }
        return update
    }

    fun clear() {
        posts = emptyArray()
        uniqId = 0// также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }
}