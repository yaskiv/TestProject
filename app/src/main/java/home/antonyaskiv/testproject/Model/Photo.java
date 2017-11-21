
package home.antonyaskiv.testproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "Photo")
public class Photo {


    @SerializedName("height")
    @Expose
    @ColumnInfo(name = "height")
    private Integer height;
    @SerializedName("html_attributions")
    @Expose
    @ColumnInfo(name = "htmlAttributions")
    private List<String> htmlAttributions = null;
    @SerializedName("photo_reference")
    @Expose
    @ColumnInfo(name = "photoReference")
    private String photoReference;
    @SerializedName("width")
    @Expose
    @ColumnInfo(name = "width")
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
