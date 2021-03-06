package com.example.micha.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by micha on 24.01.2018.
 */

public class AufgabenHeuteAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_text_zweizeilen, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return MainActivity.tododb.readAufgabeUnerledigt().size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mItemText1;
        private TextView mItemText2;
        private TextView mItemText3;
        private TextView mItemText4;
        private TextView mItemText5;

        public ListViewHolder(View itemView) {

            super(itemView);
            mItemText1 = (TextView) itemView.findViewById(R.id.textzeile1);
            mItemText2 = (TextView) itemView.findViewById(R.id.textzeile2);
            mItemText3 = (TextView) itemView.findViewById(R.id.textzeile7);
            mItemText4 = (TextView) itemView.findViewById(R.id.textzeile6);
            mItemText5 = (TextView) itemView.findViewById(R.id.textzeile5);



            itemView.setOnClickListener(this);

        }

        public void bindView(int position) {
            mItemText1.setText(MainActivity.tododb.readAufgabeUnerledigt().get(position).gibName());
            mItemText2.setText(MainActivity.tododb.readAufgabeUnerledigt().get(position).gibTurnusString() + "      " + MainActivity.tododb.readAufgabeUnerledigt().get(position).gibPositionString());
            mItemText3.setText("5");
        }


        public void onClick(View view) {
            String id = MainActivity.tododb.readAufgabeUnerledigt().get(getPosition()).gibIDString();
            MainActivity.tododb.setDone(id);
            notifyItemRemoved(getPosition());
        }

    }
}
