package home.antonyaskiv.testproject.Controllers.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import home.antonyaskiv.testproject.R;

/**
 * Created by AntonYaskiv on 22.11.2017.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView image_for_result;
    public TextView name_of_result;
    public TextView address_of_result;

    public ItemViewHolder(View itemView) {
        super(itemView);
        image_for_result= itemView.findViewById(R.id.image_for_result);
        name_of_result=itemView.findViewById(R.id.name_of_result);
        address_of_result=itemView.findViewById(R.id.address_of_result);

    }
}
