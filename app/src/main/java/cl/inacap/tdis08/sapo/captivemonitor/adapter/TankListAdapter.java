package cl.inacap.tdis08.sapo.captivemonitor.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import cl.inacap.tdis08.sapo.captivemonitor.R;
import cl.inacap.tdis08.sapo.captivemonitor.model.Tank;
import cl.inacap.tdis08.sapo.captivemonitor.util.Icons;

public class TankListAdapter extends ArrayAdapter<Tank> {

    private static final int ITEM_LAYOUT = R.layout.tank_list_item;

    private EditListener editListener;
    private DeleteListener deleteListener;
    private ViewListener viewListener;

    public TankListAdapter(Context context, ArrayList<Tank> tanks) {
        super(context, ITEM_LAYOUT, tanks);
        this.editListener = null;
        this.deleteListener = null;
        this.viewListener = null;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        Tank tank = getItem(position);
        ViewHolder viewHolder;

        if (view == null) {

            // Generar la vista
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(ITEM_LAYOUT, parent, false);

            // Guardar vista en el holder
            viewHolder = new ViewHolder();
            viewHolder.name      = (TextView) view.findViewById(R.id.text_tank_name);
            viewHolder.btnEdit   = (Button) view.findViewById(R.id.btn_edit_tank);
            viewHolder.btnDelete = (Button) view.findViewById(R.id.btn_delete_tank);
            viewHolder.btnView   = (Button) view.findViewById(R.id.btn_view_tank);
            viewHolder.icon      = (ImageView) view.findViewById(R.id.img_icon);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Llevar datos al layout
        viewHolder.name.setText(tank.getName());
        viewHolder.btnEdit.setOnClickListener(v -> {editListener.onEditButtonListener(position);});
        viewHolder.btnDelete.setOnClickListener(v -> {deleteListener.onDeleteButtonListener(position);});
        viewHolder.btnView.setOnClickListener(v -> {viewListener.onViewButtonListener(position);});
        viewHolder.icon.setImageResource(Icons.getIcon(tank.getIconId()));

        return view;
    }

    private static class ViewHolder {
        TextView name;
        Button btnEdit;
        Button btnDelete;
        Button btnView;
        ImageView icon;
    }

    // Listeners

    public interface EditListener {
        public void onEditButtonListener(int position);
    }

    public interface DeleteListener {
        public void onDeleteButtonListener(int position);
    }

    public interface ViewListener {
        public void onViewButtonListener(int position);
    }

    public void setOnEditButtonListener(EditListener listener) {
        this.editListener = listener;
    }

    public void setOnDeleteButtonListener(DeleteListener listener) {
        this.deleteListener = listener;
    }

    public void setOnViewButtonListener(ViewListener listener) {
        this.viewListener = listener;
    }

}
