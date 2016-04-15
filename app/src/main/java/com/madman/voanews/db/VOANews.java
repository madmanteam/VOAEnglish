package com.madman.voanews.db;

/**
 * Created by madman on 4/15/16.
 */
public class VOANews {

    String type;
    String category;
    String guid;
    String description;
    String pubDate;
    String title;
    String image;
    String id;
    String content;
    String link;
    String audio;
    String audioFile;

    public VOANews(String title, String desc, String category, String pubDate, String content, String image,
                   String audio){
        this.title = title;
        this.description = desc;
        this.category = category;
        this.pubDate = pubDate;
        this.content = content;
        this.image = image;
        this.audio = audio;
    }
    public VOANews(String id, String guid, String title, String desc, String category, String pubDate, String content, String image,
                   String link, String audio, String type){
        this.id = id;
        this.guid = guid;
        this.title = title;
        this.description = desc;
        this.category = category;
        this.pubDate = pubDate;
        this.content = content;
        this.image = image;
        this.link  = link;
        this.audio = audio;
        this.type = type;
    }
    public VOANews(String id, String title, String link, String pubDate) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
    }
    public VOANews(String title, String link, String pubDate) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VOANews{" +
                "category='" + category + '\'' +
                ", guid='" + guid + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", id='" + id + '\'' +
//                ", content='" + content + '\'' +
                ", link='" + link + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }
}
