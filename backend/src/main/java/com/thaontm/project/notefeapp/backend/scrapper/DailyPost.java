package com.thaontm.project.notefeapp.backend.scrapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class DailyPost implements Serializable {
    private final static long serialVersionUID = -5828515261511291090L;
    private final static String NHK_EASY_BASE_URL = "https://www3.nhk.or.jp/news/easy";
    private final static String FORWARD_SLASH = "/";
    @SerializedName("news_priority_number")
    @Expose
    private String newsPriorityNumber;
    @SerializedName("news_prearranged_time")
    @Expose
    private String newsPrearrangedTime;
    @SerializedName("news_id")
    @Expose
    private String newsId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_with_ruby")
    @Expose
    private String titleWithRuby;
    @SerializedName("news_file_ver")
    @Expose
    private Boolean newsFileVer;
    @SerializedName("news_creation_time")
    @Expose
    private String newsCreationTime;
    @SerializedName("news_preview_time")
    @Expose
    private String newsPreviewTime;
    @SerializedName("news_publication_time")
    @Expose
    private String newsPublicationTime;
    @SerializedName("news_publication_status")
    @Expose
    private Boolean newsPublicationStatus;
    @SerializedName("has_news_web_image")
    @Expose
    private Boolean hasNewsWebImage;
    @SerializedName("has_news_web_movie")
    @Expose
    private Boolean hasNewsWebMovie;
    @SerializedName("has_news_easy_image")
    @Expose
    private Boolean hasNewsEasyImage;
    @SerializedName("has_news_easy_movie")
    @Expose
    private Boolean hasNewsEasyMovie;
    @SerializedName("has_news_easy_voice")
    @Expose
    private Boolean hasNewsEasyVoice;
    @SerializedName("news_web_image_uri")
    @Expose
    private String newsWebImageUri;
    @SerializedName("news_web_movie_uri")
    @Expose
    private String newsWebMovieUri;
    @SerializedName("news_easy_image_uri")
    @Expose
    private String newsEasyImageUri;
    @SerializedName("news_easy_movie_uri")
    @Expose
    private String newsEasyMovieUri;
    @SerializedName("news_easy_voice_uri")
    @Expose
    private String newsEasyVoiceUri;
    @SerializedName("news_display_flag")
    @Expose
    private Boolean newsDisplayFlag;
    @SerializedName("news_web_url")
    @Expose
    private String newsWebUrl;

    /**
     * No args constructor for use in serialization
     */
    public DailyPost() {
    }

    /**
     * @param hasNewsWebMovie has a news web movie
     * @param newsWebImageUri news web image uri
     * @param hasNewsEasyMovie has a news easy movie
     * @param titleWithRuby title with ruby
     * @param newsWebUrl news web url
     * @param hasNewsEasyVoice has news easy voice
     * @param newsEasyVoiceUri news easy voice uri
     * @param newsEasyMovieUri news easy movie uri
     * @param newsPriorityNumber news priority number
     * @param newsDisplayFlag news display flag
     * @param hasNewsEasyImage has news easy image
     * @param newsPublicationStatus news publication status
     * @param newsFileVer news file ver
     * @param newsWebMovieUri news web movie uri
     * @param hasNewsWebImage has news web image
     * @param newsPrearrangedTime news prearrange time
     * @param title title
     * @param newsId news id
     * @param newsCreationTime news creation time
     * @param newsPreviewTime news preview time
     * @param newsEasyImageUri news easy image uri
     * @param newsPublicationTime news publication time
     */
    public DailyPost(String newsPriorityNumber, String newsPrearrangedTime, String newsId, String title,
            String titleWithRuby, Boolean newsFileVer, String newsCreationTime, String newsPreviewTime,
            String newsPublicationTime, Boolean newsPublicationStatus, Boolean hasNewsWebImage, Boolean hasNewsWebMovie,
            Boolean hasNewsEasyImage, Boolean hasNewsEasyMovie, Boolean hasNewsEasyVoice, String newsWebImageUri,
            String newsWebMovieUri, String newsEasyImageUri, String newsEasyMovieUri, String newsEasyVoiceUri,
            Boolean newsDisplayFlag, String newsWebUrl) {
        this.newsPriorityNumber = newsPriorityNumber;
        this.newsPrearrangedTime = newsPrearrangedTime;
        this.newsId = newsId;
        this.title = title;
        this.titleWithRuby = titleWithRuby;
        this.newsFileVer = newsFileVer;
        this.newsCreationTime = newsCreationTime;
        this.newsPreviewTime = newsPreviewTime;
        this.newsPublicationTime = newsPublicationTime;
        this.newsPublicationStatus = newsPublicationStatus;
        this.hasNewsWebImage = hasNewsWebImage;
        this.hasNewsWebMovie = hasNewsWebMovie;
        this.hasNewsEasyImage = hasNewsEasyImage;
        this.hasNewsEasyMovie = hasNewsEasyMovie;
        this.hasNewsEasyVoice = hasNewsEasyVoice;
        this.newsWebImageUri = newsWebImageUri;
        this.newsWebMovieUri = newsWebMovieUri;
        this.newsEasyImageUri = newsEasyImageUri;
        this.newsEasyMovieUri = newsEasyMovieUri;
        this.newsEasyVoiceUri = newsEasyVoiceUri;
        this.newsDisplayFlag = newsDisplayFlag;
        this.newsWebUrl = newsWebUrl;
    }

    public String getNewsPriorityNumber() {
        return newsPriorityNumber;
    }

    public void setNewsPriorityNumber(String newsPriorityNumber) {
        this.newsPriorityNumber = newsPriorityNumber;
    }

    public DailyPost withNewsPriorityNumber(String newsPriorityNumber) {
        this.newsPriorityNumber = newsPriorityNumber;
        return this;
    }

    public String getNewsPrearrangedTime() {
        return newsPrearrangedTime;
    }

    public void setNewsPrearrangedTime(String newsPrearrangedTime) {
        this.newsPrearrangedTime = newsPrearrangedTime;
    }

    public DailyPost withNewsPrearrangedTime(String newsPrearrangedTime) {
        this.newsPrearrangedTime = newsPrearrangedTime;
        return this;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(final String newsId) {
        this.newsId = newsId;
    }

    public DailyPost withNewsId(String newsId) {
        this.newsId = newsId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DailyPost withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitleWithRuby() {
        return titleWithRuby;
    }

    public void setTitleWithRuby(String titleWithRuby) {
        this.titleWithRuby = titleWithRuby;
    }

    public DailyPost withTitleWithRuby(String titleWithRuby) {
        this.titleWithRuby = titleWithRuby;
        return this;
    }

    public Boolean getNewsFileVer() {
        return newsFileVer;
    }

    public void setNewsFileVer(Boolean newsFileVer) {
        this.newsFileVer = newsFileVer;
    }

    public DailyPost withNewsFileVer(Boolean newsFileVer) {
        this.newsFileVer = newsFileVer;
        return this;
    }

    public String getNewsCreationTime() {
        return newsCreationTime;
    }

    public void setNewsCreationTime(String newsCreationTime) {
        this.newsCreationTime = newsCreationTime;
    }

    public DailyPost withNewsCreationTime(String newsCreationTime) {
        this.newsCreationTime = newsCreationTime;
        return this;
    }

    public String getNewsPreviewTime() {
        return newsPreviewTime;
    }

    public void setNewsPreviewTime(String newsPreviewTime) {
        this.newsPreviewTime = newsPreviewTime;
    }

    public DailyPost withNewsPreviewTime(String newsPreviewTime) {
        this.newsPreviewTime = newsPreviewTime;
        return this;
    }

    public String getNewsPublicationTime() {
        return newsPublicationTime;
    }

    public void setNewsPublicationTime(String newsPublicationTime) {
        this.newsPublicationTime = newsPublicationTime;
    }

    public DailyPost withNewsPublicationTime(String newsPublicationTime) {
        this.newsPublicationTime = newsPublicationTime;
        return this;
    }

    public Boolean getNewsPublicationStatus() {
        return newsPublicationStatus;
    }

    public void setNewsPublicationStatus(Boolean newsPublicationStatus) {
        this.newsPublicationStatus = newsPublicationStatus;
    }

    public DailyPost withNewsPublicationStatus(Boolean newsPublicationStatus) {
        this.newsPublicationStatus = newsPublicationStatus;
        return this;
    }

    public Boolean getHasNewsWebImage() {
        return hasNewsWebImage;
    }

    public void setHasNewsWebImage(Boolean hasNewsWebImage) {
        this.hasNewsWebImage = hasNewsWebImage;
    }

    public DailyPost withHasNewsWebImage(Boolean hasNewsWebImage) {
        this.hasNewsWebImage = hasNewsWebImage;
        return this;
    }

    public Boolean getHasNewsWebMovie() {
        return hasNewsWebMovie;
    }

    public void setHasNewsWebMovie(Boolean hasNewsWebMovie) {
        this.hasNewsWebMovie = hasNewsWebMovie;
    }

    public DailyPost withHasNewsWebMovie(Boolean hasNewsWebMovie) {
        this.hasNewsWebMovie = hasNewsWebMovie;
        return this;
    }

    public Boolean getHasNewsEasyImage() {
        return hasNewsEasyImage;
    }

    public void setHasNewsEasyImage(Boolean hasNewsEasyImage) {
        this.hasNewsEasyImage = hasNewsEasyImage;
    }

    public DailyPost withHasNewsEasyImage(Boolean hasNewsEasyImage) {
        this.hasNewsEasyImage = hasNewsEasyImage;
        return this;
    }

    public Boolean getHasNewsEasyMovie() {
        return hasNewsEasyMovie;
    }

    public void setHasNewsEasyMovie(Boolean hasNewsEasyMovie) {
        this.hasNewsEasyMovie = hasNewsEasyMovie;
    }

    public DailyPost withHasNewsEasyMovie(Boolean hasNewsEasyMovie) {
        this.hasNewsEasyMovie = hasNewsEasyMovie;
        return this;
    }

    public Boolean getHasNewsEasyVoice() {
        return hasNewsEasyVoice;
    }

    public void setHasNewsEasyVoice(Boolean hasNewsEasyVoice) {
        this.hasNewsEasyVoice = hasNewsEasyVoice;
    }

    public DailyPost withHasNewsEasyVoice(Boolean hasNewsEasyVoice) {
        this.hasNewsEasyVoice = hasNewsEasyVoice;
        return this;
    }

    public String getNewsWebImageUri() {
        return newsWebImageUri;
    }

    public void setNewsWebImageUri(String newsWebImageUri) {
        this.newsWebImageUri = newsWebImageUri;
    }

    public DailyPost withNewsWebImageUri(String newsWebImageUri) {
        this.newsWebImageUri = newsWebImageUri;
        return this;
    }

    public String getNewsWebMovieUri() {
        return newsWebMovieUri;
    }

    public void setNewsWebMovieUri(String newsWebMovieUri) {
        this.newsWebMovieUri = newsWebMovieUri;
    }

    public DailyPost withNewsWebMovieUri(String newsWebMovieUri) {
        this.newsWebMovieUri = newsWebMovieUri;
        return this;
    }

    public String getNewsEasyImageUri() {
        return newsEasyImageUri;
    }

    public void setNewsEasyImageUri(String newsEasyImageUri) {
        this.newsEasyImageUri = newsEasyImageUri;
    }

    public DailyPost withNewsEasyImageUri(String newsEasyImageUri) {
        this.newsEasyImageUri = newsEasyImageUri;
        return this;
    }

    public String getNewsEasyMovieUri() {
        return newsEasyMovieUri;
    }

    public void setNewsEasyMovieUri(String newsEasyMovieUri) {
        this.newsEasyMovieUri = newsEasyMovieUri;
    }

    public DailyPost withNewsEasyMovieUri(String newsEasyMovieUri) {
        this.newsEasyMovieUri = newsEasyMovieUri;
        return this;
    }

    public String getNewsEasyVoiceUri() {
        return newsEasyVoiceUri;
    }

    public void setNewsEasyVoiceUri(String newsEasyVoiceUri) {
        this.newsEasyVoiceUri = newsEasyVoiceUri;
    }

    public DailyPost withNewsEasyVoiceUri(String newsEasyVoiceUri) {
        this.newsEasyVoiceUri = newsEasyVoiceUri;
        return this;
    }

    public Boolean getNewsDisplayFlag() {
        return newsDisplayFlag;
    }

    public void setNewsDisplayFlag(Boolean newsDisplayFlag) {
        this.newsDisplayFlag = newsDisplayFlag;
    }

    public DailyPost withNewsDisplayFlag(Boolean newsDisplayFlag) {
        this.newsDisplayFlag = newsDisplayFlag;
        return this;
    }

    public String getNewsWebUrl() {
        return NHK_EASY_BASE_URL + FORWARD_SLASH + getNewsId() + FORWARD_SLASH + getNewsId() + ".html";
    }

    public void setNewsWebUrl(String newsWebUrl) {
        this.newsWebUrl = newsWebUrl;
    }

    public DailyPost withNewsWebUrl(String newsWebUrl) {
        this.newsWebUrl = newsWebUrl;
        return this;
    }

    public String getNewsJsonUrl() {
        return NHK_EASY_BASE_URL + FORWARD_SLASH + getNewsId() + FORWARD_SLASH + getNewsId() + ".out.json";
    }

    /**
     * This method is to get json from the news json url and then get the text element.
     *
     * @return the text content of the post
     */
    public String getTextContent() {
        String result;
        try {
            String json = IOUtils.toString(new URL(getNewsJsonUrl()));
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(json);
            result = element.getAsJsonObject().get("text").toString().replaceAll("^\"|\"$", "");
        } catch (IOException e) {
            result = StringUtils.EMPTY;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("newsPriorityNumber", newsPriorityNumber)
                .append("newsPrearrangedTime", newsPrearrangedTime)
                .append("newsId", newsId).append("title", title)
                .append("titleWithRuby", titleWithRuby)
                .append("newsFileVer", newsFileVer)
                .append("newsCreationTime", newsCreationTime)
                .append("newsPreviewTime", newsPreviewTime)
                .append("newsPublicationTime", newsPublicationTime)
                .append("newsPublicationStatus", newsPublicationStatus)
                .append("hasNewsWebImage", hasNewsWebImage)
                .append("hasNewsWebMovie", hasNewsWebMovie)
                .append("hasNewsEasyImage", hasNewsEasyImage)
                .append("hasNewsEasyMovie", hasNewsEasyMovie)
                .append("hasNewsEasyVoice", hasNewsEasyVoice)
                .append("newsWebImageUri", newsWebImageUri)
                .append("newsWebMovieUri", newsWebMovieUri)
                .append("newsEasyImageUri", newsEasyImageUri)
                .append("newsEasyMovieUri", newsEasyMovieUri)
                .append("newsEasyVoiceUri", newsEasyVoiceUri)
                .append("newsDisplayFlag", newsDisplayFlag)
                .append("newsWebUrl", newsWebUrl)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(hasNewsWebMovie)
                .append(newsWebImageUri)
                .append(hasNewsEasyMovie)
                .append(titleWithRuby)
                .append(newsWebUrl)
                .append(hasNewsEasyVoice)
                .append(newsEasyVoiceUri)
                .append(newsEasyMovieUri)
                .append(newsPriorityNumber)
                .append(newsDisplayFlag)
                .append(hasNewsEasyImage)
                .append(newsPublicationStatus)
                .append(newsFileVer)
                .append(newsWebMovieUri)
                .append(hasNewsWebImage)
                .append(newsPrearrangedTime)
                .append(title)
                .append(newsPreviewTime)
                .append(newsCreationTime)
                .append(newsId)
                .append(newsEasyImageUri)
                .append(newsPublicationTime)
                .toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DailyPost)) {
            return false;
        }
        final DailyPost rhs = ((DailyPost) other);
        return new EqualsBuilder()
                .append(hasNewsWebMovie, rhs.hasNewsWebMovie)
                .append(newsWebImageUri, rhs.newsWebImageUri)
                .append(hasNewsEasyMovie, rhs.hasNewsEasyMovie)
                .append(titleWithRuby, rhs.titleWithRuby)
                .append(newsWebUrl, rhs.newsWebUrl)
                .append(hasNewsEasyVoice, rhs.hasNewsEasyVoice)
                .append(newsEasyVoiceUri, rhs.newsEasyVoiceUri)
                .append(newsEasyMovieUri, rhs.newsEasyMovieUri)
                .append(newsPriorityNumber, rhs.newsPriorityNumber)
                .append(newsDisplayFlag, rhs.newsDisplayFlag)
                .append(hasNewsEasyImage, rhs.hasNewsEasyImage)
                .append(newsPublicationStatus, rhs.newsPublicationStatus)
                .append(newsFileVer, rhs.newsFileVer)
                .append(newsWebMovieUri, rhs.newsWebMovieUri)
                .append(hasNewsWebImage, rhs.hasNewsWebImage)
                .append(newsPrearrangedTime, rhs.newsPrearrangedTime)
                .append(title, rhs.title)
                .append(newsPreviewTime, rhs.newsPreviewTime)
                .append(newsCreationTime, rhs.newsCreationTime)
                .append(newsId, rhs.newsId)
                .append(newsEasyImageUri, rhs.newsEasyImageUri)
                .append(newsPublicationTime, rhs.newsPublicationTime)
                .isEquals();
    }
}
