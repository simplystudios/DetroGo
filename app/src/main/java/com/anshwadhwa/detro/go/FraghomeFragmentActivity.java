package com.anshwadhwa.detro.go;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.customview.*;
import androidx.fragment.*;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.versionedparcelable.*;
import androidx.viewpager.*;
import com.google.android.material.*;
import com.google.android.material.button.*;
import com.google.android.material.card.*;
import com.google.android.material.textfield.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class FraghomeFragmentActivity extends Fragment {
	
	private HashMap<String, Object> lines = new HashMap<>();
	private double n = 0;
	private HashMap<String, Object> tempmap = new HashMap<>();
	
	private ArrayList<String> tempste = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> linesmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> routedata = new ArrayList<>();
	
	private NestedScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout head;
	private LinearLayout linear134;
	private RecyclerView recyclerview1;
	private LinearLayout linear15;
	private LinearLayout linear139;
	private LinearLayout linear143;
	private LinearLayout linear153;
	private ImageView imageview4;
	private LinearLayout linear147;
	private ImageView imageview3;
	private LinearLayout linear145;
	private ImageView imageview5;
	private LinearLayout linear151;
	private MaterialCardView cardview1;
	private LinearLayout linear152;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private LinearLayout linear44;
	private LinearLayout linear122;
	private LinearLayout linear124;
	private LinearLayout linear148;
	private TextView textview10;
	private TextView textview14;
	private TextInputLayout textinputlayout4;
	private LinearLayout linear137;
	private TextInputLayout textinputlayout5;
	private LinearLayout linear49;
	private LinearLayout linear138;
	private AutoCompleteTextView autocomplete1;
	private AutoCompleteTextView autocomplete3;
	private MaterialButton button1;
	private TextView textview12;
	private LinearLayout linear144;
	private TextView textview13;
	
	private RequestNetwork r;
	private RequestNetwork.RequestListener _r_request_listener;
	private Intent i = new Intent();
	private SharedPreferences routes;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.fraghome_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		head = _view.findViewById(R.id.head);
		linear134 = _view.findViewById(R.id.linear134);
		recyclerview1 = _view.findViewById(R.id.recyclerview1);
		linear15 = _view.findViewById(R.id.linear15);
		linear139 = _view.findViewById(R.id.linear139);
		linear143 = _view.findViewById(R.id.linear143);
		linear153 = _view.findViewById(R.id.linear153);
		imageview4 = _view.findViewById(R.id.imageview4);
		linear147 = _view.findViewById(R.id.linear147);
		imageview3 = _view.findViewById(R.id.imageview3);
		linear145 = _view.findViewById(R.id.linear145);
		imageview5 = _view.findViewById(R.id.imageview5);
		linear151 = _view.findViewById(R.id.linear151);
		cardview1 = _view.findViewById(R.id.cardview1);
		linear152 = _view.findViewById(R.id.linear152);
		linear31 = _view.findViewById(R.id.linear31);
		linear32 = _view.findViewById(R.id.linear32);
		linear44 = _view.findViewById(R.id.linear44);
		linear122 = _view.findViewById(R.id.linear122);
		linear124 = _view.findViewById(R.id.linear124);
		linear148 = _view.findViewById(R.id.linear148);
		textview10 = _view.findViewById(R.id.textview10);
		textview14 = _view.findViewById(R.id.textview14);
		textinputlayout4 = _view.findViewById(R.id.textinputlayout4);
		linear137 = _view.findViewById(R.id.linear137);
		textinputlayout5 = _view.findViewById(R.id.textinputlayout5);
		linear49 = _view.findViewById(R.id.linear49);
		linear138 = _view.findViewById(R.id.linear138);
		autocomplete1 = _view.findViewById(R.id.autocomplete1);
		autocomplete3 = _view.findViewById(R.id.autocomplete3);
		button1 = _view.findViewById(R.id.button1);
		textview12 = _view.findViewById(R.id.textview12);
		linear144 = _view.findViewById(R.id.linear144);
		textview13 = _view.findViewById(R.id.textview13);
		r = new RequestNetwork((Activity) getContext());
		routes = getContext().getSharedPreferences("routes", Activity.MODE_PRIVATE);
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setClass(getContext().getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((autocomplete1.getText().toString().length() > 0) && (autocomplete3.getText().toString().length() > 0)) {
					if (autocomplete1.getText().toString().equals(autocomplete3.getText().toString())) {
						autocomplete1.setText("");
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Can't have same station as starting and ending point");
					} else {
						i.setAction(Intent.ACTION_VIEW);
						i.setClass(getContext().getApplicationContext(), MetroroutepgActivity.class);
						i.putExtra("from", autocomplete1.getText().toString());
						i.putExtra("to", autocomplete3.getText().toString());
						startActivity(i);
					}
					if (autocomplete3.getText().toString().equals(autocomplete1.getText().toString())) {
						autocomplete1.setText("");
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Can't have same station as starting and ending point");
					} else {
						i.setAction(Intent.ACTION_VIEW);
						i.setClass(getContext().getApplicationContext(), MetroroutepgActivity.class);
						i.putExtra("from", autocomplete1.getText().toString());
						i.putExtra("to", autocomplete3.getText().toString());
						startActivity(i);
					}
				} else {
					SketchwareUtil.showMessage(getContext().getApplicationContext(), "Empty Field");
				}
			}
		});
		
		_r_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "No Connection Error 404 : ".concat(_message));
			}
		};
	}
	
	private void initializeLogic() {
		imageview3.setColorFilter(SketchwareUtil.getMaterialColor(getContext(), com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		imageview5.setColorFilter(SketchwareUtil.getMaterialColor(getContext(), com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		imageview4.setColorFilter(SketchwareUtil.getMaterialColor(getContext(), com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
		r.startRequestNetwork(RequestNetworkController.GET, "https://detroweb.vercel.app", "A", _r_request_listener);
		// 1. Get density for consistent DP calculation
		float density = cardview1.getContext().getResources().getDisplayMetrics().density;
		float radiusExpressive = 24f * density; 
		
		// 2. Cast to MaterialCardView
		com.google.android.material.card.MaterialCardView mCard = (com.google.android.material.card.MaterialCardView) cardview1;
		
		// 3. Set the Material 3 Expressive Shape (24dp corners)
		mCard.setShapeAppearanceModel(
		mCard.getShapeAppearanceModel()
		.toBuilder()
		.setAllCornerSizes(radiusExpressive)
		.build()
		);
		
		// 4. Apply Material 3 Theme Colors
		// Using Surface Container for that modern M3 look
		int m3SurfaceColor = SketchwareUtil.getMaterialColor(mCard.getContext(), com.google.android.material.R.attr.colorSurfaceContainer);
		mCard.setCardBackgroundColor(m3SurfaceColor);
		
		// 5. Set Elevation and Padding
		mCard.setCardElevation(2f * density); // Light elevation for the homepage card
		int pLR = (int)(16 * density);
		int pTB = (int)(12 * density);
		mCard.setContentPadding(pLR, pTB, pLR, pTB);
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!routes.getString("data", "").equals("")) {
			routedata = new Gson().fromJson(routes.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			Collections.reverse(routedata);
			recyclerview1.setAdapter(new Recyclerview1Adapter(routedata));
		} else {
			
		}
	}
	public void _MaterialListUi_(final View _view, final ArrayList<HashMap<String, Object>> _listmap, final double _position, final String _color) {
		// 1. Get density for the unified 24dp blob radius
		float density = _view.getContext().getResources().getDisplayMetrics().density;
		float radiusBlob = 24f * density; 
		float radiusInner = 4f * density; 
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		// 2. DYNAMIC COLOR: Grab the M3 Surface Container color from the theme
		// This replaces the 'parseColor' logic to prevent crashes
		int m3SurfaceColor = SketchwareUtil.getMaterialColor(_view.getContext(), com.google.android.material.R.attr.colorSurfaceContainer);
		gd.setColor(m3SurfaceColor);
		
		// 3. The Aesthetic Grouping Logic
		float tl = radiusInner, tr = radiusInner, br = radiusInner, bl = radiusInner;
		
		if (_listmap != null && !_listmap.isEmpty()) {
			if (_listmap.size() == 1) {
				tl = tr = br = bl = radiusBlob;
			} else if (_position == 0) {
				tl = tr = radiusBlob;
			} else if (_position == _listmap.size() - 1) {
				bl = br = radiusBlob;
			}
		}
		
		gd.setCornerRadii(new float[] {tl, tl, tr, tr, br, br, bl, bl});
		
		// 4. Apply background and center content
		_view.setBackground(gd);
		if (_view instanceof LinearLayout) {
			((LinearLayout)_view).setGravity(Gravity.CENTER_VERTICAL);
		}
		
		// 5. M3 Standard Padding
		int pLR = (int)(16 * density);
		int pTB = (int)(12 * density);
		_view.setPadding(pLR, pTB, pLR, pTB);
		
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.ggt, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.google.android.material.card.MaterialCardView linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			_MaterialListUi_(linear5, _data, _position, "");
			textview2.setVisibility(View.GONE);
			textview1.setText(_data.get((int)_position).get("route").toString());
			imageview1.setColorFilter(SketchwareUtil.getMaterialColor(getContext(), com.google.android.material.R.attr.colorOnPrimaryContainer), PorterDuff.Mode.MULTIPLY);
			linear5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					// 1. Get the current text from the UI
					String fullText = textview1.getText().toString();
					
					// 2. Determine which arrow is being used and split
					String delimiter = fullText.contains(" → ") ? " → " : "->";
					
					if (fullText.contains(delimiter)) {
						String[] parts = fullText.split(delimiter);
						
						// 3. Setup Intent and pass both values
						if (parts.length >= 2) {
							Intent i = new Intent();
							i.setClass(getActivity(), MetroroutepgActivity.class);
							i.putExtra("from", parts[0].trim());
							i.putExtra("to", parts[1].trim());
							startActivity(i);
						}
					}
					
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}
