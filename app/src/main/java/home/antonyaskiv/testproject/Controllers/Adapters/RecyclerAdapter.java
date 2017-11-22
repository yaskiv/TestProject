package home.antonyaskiv.testproject.Controllers.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import home.antonyaskiv.testproject.Controllers.Adapters.ViewHolder.ItemViewHolder;
import home.antonyaskiv.testproject.Controllers.View.Activitys.InformationActivity;
import home.antonyaskiv.testproject.Controllers.View.Activitys.MainActivity;
import home.antonyaskiv.testproject.Controllers.View.DataTransmission.FromMainToInformation;
import home.antonyaskiv.testproject.Model.Result;
import home.antonyaskiv.testproject.R;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by AntonYaskiv on 22.11.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Result> list_of_result;
    Context context;
    public RecyclerAdapter(List<Result> ListOfResult,Context context) {
        list_of_result=ListOfResult;
        this.context=context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.name_of_result.setText(list_of_result.get(position).getName());
        holder.address_of_result.setText(list_of_result.get(position).getVicinity());
        Uri uri = Uri.parse(list_of_result.get(position).getIcon());
        holder.image_for_result.setImageURI(uri);
        Log.d("ViewHolder",list_of_result.get(position).getName());
        holder.itemView.setOnClickListener(p->
        {
            Intent intent=new Intent(context, InformationActivity.class);
            intent.putExtra("FromMainToInformation",new FromMainToInformation(
                    list_of_result.get(position).getGeometry().getLocation().getLat()
                    ,list_of_result.get(position).getGeometry().getLocation().getLng()
                    ,list_of_result.get(position).getIcon()
                    ,list_of_result.get(position).getName()
                    ,list_of_result.get(position).getVicinity()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list_of_result.size();
    }

}
