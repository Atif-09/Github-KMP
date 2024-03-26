package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchUserDataClass(
    @SerialName("avatar_url")
    val avatar_url: String,
    @SerialName("bio")
    var bio: String? = null,
    @SerialName("blog")
    val blog: String,
    @SerialName("company")
    val company: String? = null,
    @SerialName("created_at")
    val created_at: String,
    @SerialName("email")
    val email: String? = null,
    @SerialName("events_url")
    val events_url: String,
    @SerialName("followers")
    val followers: Int,
    @SerialName("followers_url")
    val followers_url: String,
    @SerialName("following")
    val following: Int,
    @SerialName("following_url")
    val following_url: String,
    @SerialName("gists_url")
    val gists_url: String,
    @SerialName("gravatar_id")
    val gravatar_id: String,
    @SerialName("hireable")
    var hireable: Boolean? = null,
    @SerialName("html_url")
    val html_url: String,
    @SerialName("id")
    val id: Int,
    @SerialName("location")
    val location: String? = null,
    @SerialName("login")
    val login: String,
    @SerialName("name")
    val name: String,
    @SerialName("node_id")
    val node_id: String,
    @SerialName("organizations_url")
    val organizations_url: String,
    @SerialName("public_gists")
    val public_gists: Int,
    @SerialName("public_repos")
    val public_repos: Int,
    @SerialName("received_events_url")
    val received_events_url: String,
    @SerialName("repos_url")
    val repos_url: String,
    @SerialName("site_admin")
    val site_admin: Boolean,
    @SerialName("starred_url")
    val starred_url: String,
    @SerialName("subscriptions_url")
    val subscriptions_url: String,
    @SerialName("twitter_username")
    val twitter_username: String? = null,
    @SerialName("type")
    val type: String,
    @SerialName("updated_at")
    val updated_at: String,
    @SerialName("url")
    val url: String
)