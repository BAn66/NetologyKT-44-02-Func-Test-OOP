import java.time.*

fun main(args: Array<String>) {

}

data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: LocalDate = LocalDate.now(),
    var text: String = "empty",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    var comments: Comments = Comments(),
    val copyright: String = "$ownerId",
    val likes: Likes? = Likes(),
    val reposts: Reposts? = Reposts(),
    val views: Int = 0,
    val postType: PostType = PostType.POST,
    val postSource : PostSource? = PostSource(),
   // val attachments: Array<Attachments> = emptyArray<Attachments>(),
    val geo: Geo? = Geo(),
    val signerId: Int = 0,
    //val copyHistory: Array<Post> = emptyArray<Post>(),
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsADS: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int = 0
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

    class PostSource {}
    class Attachments {}
    class Geo {}
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
