
package home.antonyaskiv.testproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import home.antonyaskiv.testproject.Model.Converters.OpeningHoursTypeConverter;
@Entity(tableName = "OpeningHours")
@TypeConverters({OpeningHoursTypeConverter.class})
public class OpeningHours {


    @SerializedName("open_now")
    @Expose
    @ColumnInfo(name = "openNow")
    private Boolean openNow;
    @SerializedName("weekday_text")
    @Expose
    @ColumnInfo(name = "weekdayText")

    private List<String> weekdayText = null;

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
    }

}
