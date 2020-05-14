package com.haerul.swipeviewpager;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends PagerAdapter {

    public static int a=0; // 구분

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        final ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

///수정시작
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    a=0;

                    context.startActivity(intent);

                }
                else if(position==1){
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);
                    a=1;
                }
                else if(position==2){
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);
                    a=2;
                }
                else if(position==3){
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("param", models.get(position).getTitle());
                    context.startActivity(intent);
                    a=3;
                }

            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
