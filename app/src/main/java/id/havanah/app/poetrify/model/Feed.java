package id.havanah.app.poetrify.model;

/**
 * Created by farhan at 0:20
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class Feed {
  private String userAvatar, feedImage, username, likes, caption, copyright, created_at, updated_at;

  public Feed(String userAvatar, String feedImage, String username, String likes, String caption, String copyright, String created_at, String updated_at) {
    this.userAvatar = userAvatar;
    this.feedImage = feedImage;
    this.username = username;
    this.likes = likes;
    this.caption = caption;
    this.copyright = copyright;
    this.created_at = created_at;
    this.updated_at = updated_at;
  }

  public String getUserAvatar() {
    return userAvatar;
  }

  public String getFeedImage() {
    return feedImage;
  }

  public String getUsername() {
    return username;
  }

  public String getLikes() {
    return likes;
  }

  public String getCaption() {
    return caption;
  }

  public String getCopyright() {
    return copyright;
  }

  public String getCreated_at() {
    return created_at;
  }

  public String getUpdated_at() {
    return updated_at;
  }
}
