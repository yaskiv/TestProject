
package home.antonyaskiv.testproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import home.antonyaskiv.testproject.Model.Converters.OpeningHoursTypeConverter;
import home.antonyaskiv.testproject.Model.Converters.ResultConverter;

@Entity(tableName = "result")
@TypeConverters({ResultConverter.class})
public class Result {
    public Result() {
    }

    @NonNull
    public int getId_() {
        return id_;
    }

    public void setId_(@NonNull int id_) {
        this.id_ = id_;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_")
    @NonNull
        private int id_;

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    @NonNull
    private String id;
    @SerializedName("geometry")
    @Expose
    @Embedded
    private Geometry geometry;
    @SerializedName("icon")
    @Expose
    @ColumnInfo(name = "icon")
    private String icon;
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;
    @SerializedName("place_id")
    @Expose
    @ColumnInfo(name = "place_id")
    private String placeId;
    @SerializedName("reference")
    @Expose
    @ColumnInfo(name = "reference")
    private String reference;
    @SerializedName("scope")
    @Expose
    @ColumnInfo(name = "scope")
    private String scope;
    @SerializedName("types")
    @Expose
    @ColumnInfo(name = "types")
    private List<String> types = null;
    @SerializedName("vicinity")
    @Expose
    @ColumnInfo(name = "vicinity")
    private String vicinity;
    @SerializedName("rating")
    @Expose
    @ColumnInfo(name = "rating")
    private Integer rating;
    @SerializedName("opening_hours")
    @Expose
    @Embedded
    private OpeningHours openingHours;
    @SerializedName("photos")
    @ColumnInfo(name = "photos")
    @Expose
    private List<Photo> photos = null;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}
