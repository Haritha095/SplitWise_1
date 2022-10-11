package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;
    private Button button;
    private ImageView imageView;
    private static final String IMAGE_VIEW_TAG = "A BEAGLE IMAGE";
    private static final String TEXT_VIEW_TAG = "DRAG TEXT";
    private static final String BUTTON_VIEW_TAG = "DRAG BUTTON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        implementEvents();
    }

    //Find all views and set Tag to all draggable views
    private void findViews() {
        textView = findViewById(R.id.draggable_text);
        textView.setTag(TEXT_VIEW_TAG);
        imageView = findViewById(R.id.draggable_image);
        imageView.setTag(IMAGE_VIEW_TAG);
        button = findViewById(R.id.draggable_button);
        button.setTag(BUTTON_VIEW_TAG);
    }


    //Implement long click and drag listener
    private void implementEvents() {
        //views needed to be dragged
        textView.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);
        button.setOnLongClickListener(this);

        //views needed to accept drag
        findViewById(R.id.top_layout).setOnDragListener(this);
        findViewById(R.id.left_layout).setOnDragListener(this);
        findViewById(R.id.right_layout).setOnDragListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        view.startDrag(data, shadowBuilder, view, 0);

        view.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent event) {
        boolean result = false;
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    result = true;
                    break;
                }
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                view.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_IN);
                // Invalidate the view to force a redraw in the new tint
                view.invalidate();
                result = true;
                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                result = true;
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                view.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                result = true;
                break;
            case DragEvent.ACTION_DROP:

                ClipData.Item item = event.getClipData().getItemAt(0);

                String dragData = item.getText().toString();
                Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();

                view.getBackground().clearColorFilter();

                view.invalidate();

                View v = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) v.getParent();
                owner.removeView(v);//remove the dragged view
                LinearLayout container = (LinearLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                container.addView(v);//Add the dragged view
                v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                result = true;
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                view.getBackground().clearColorFilter();
                view.invalidate();

                // Does a getResult(), and displays what happened.
                if (event.getResult())
                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                result = true;
                break;

            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return result;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}