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
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.card.*;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.search.SearchBar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class MetroroutepgActivity extends AppCompatActivity {
	
	private HashMap<String, Object> tempmap = new HashMap<>();
	private double n = 0;
	private HashMap<String, Object> lines = new HashMap<>();
	private double y = 0;
	private HashMap<String, Object> transferss = new HashMap<>();
	private double k = 0;
	private HashMap<String, Object> templines = new HashMap<>();
	private boolean hmm_bruh = false;
	
	private ArrayList<HashMap<String, Object>> linesmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> routesdata = new ArrayList<>();
	private ArrayList<String> temptrans = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> transmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> tempste = new ArrayList<>();
	
	private LinearLayout linear1;
	private NestedScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private TextView textview1;
	private LoadingIndicator loadingIndicator3;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private LinearLayout linear59;
	private RecyclerView recyclerview1;
	private SearchBar Searchbar;
	private MaterialCardView cardview1;
	private LinearLayout linear7;
	private LinearLayout linear19;
	private LinearLayout linear54;
	private MaterialButtonToggleGroup linear51;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private ImageView imageview3;
	private TextView stops;
	private ImageView imageview1;
	private TextView frm;
	private MaterialButton button25;
	private LinearLayout linear57;
	private ImageView imageview4;
	private TextView transfers;
	private ImageView imageview2;
	private TextView to;
	private TextView textview11;
	
	private Intent i = new Intent();
	private RequestNetwork r;
	private RequestNetwork.RequestListener _r_request_listener;
	private SharedPreferences routes;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.metroroutepg);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear5 = findViewById(R.id.linear5);
		textview1 = findViewById(R.id.textview1);
		loadingIndicator3 = findViewById(R.id.loadingIndicator3);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		linear52 = findViewById(R.id.linear52);
		linear53 = findViewById(R.id.linear53);
		linear59 = findViewById(R.id.linear59);
		recyclerview1 = findViewById(R.id.recyclerview1);
		Searchbar = findViewById(R.id.Searchbar);
		cardview1 = findViewById(R.id.cardview1);
		linear7 = findViewById(R.id.linear7);
		linear19 = findViewById(R.id.linear19);
		linear54 = findViewById(R.id.linear54);
		linear51 = findViewById(R.id.linear51);
		linear55 = findViewById(R.id.linear55);
		linear56 = findViewById(R.id.linear56);
		imageview3 = findViewById(R.id.imageview3);
		stops = findViewById(R.id.stops);
		imageview1 = findViewById(R.id.imageview1);
		frm = findViewById(R.id.frm);
		button25 = findViewById(R.id.button25);
		linear57 = findViewById(R.id.linear57);
		imageview4 = findViewById(R.id.imageview4);
		transfers = findViewById(R.id.transfers);
		imageview2 = findViewById(R.id.imageview2);
		to = findViewById(R.id.to);
		textview11 = findViewById(R.id.textview11);
		r = new RequestNetwork(this);
		routes = getSharedPreferences("routes", Activity.MODE_PRIVATE);
		
		Searchbar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hmm_bruh = !hmm_bruh;
				if (hmm_bruh) {
					android.transition.TransitionManager.beginDelayedTransition(Searchbar);
					
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
					
					params.setMargins(0, 0, 0, 0);
					
					// Assuming 'kol' was meant to be some view, but it's not defined in the class. 
					// Keeping it as is if it's supposed to be somewhere else or just a snippet.
					// Searchbar.setLayoutParams(params); // Maybe this was intended?
				} else {
					android.transition.TransitionManager.beginDelayedTransition(Searchbar);
					
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					params.setMargins(16, 16, 16, 16);
					
					// Searchbar.setLayoutParams(params); // Maybe this was intended?
				}
			}
		});
		
		button25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (frm.getText().toString().equals(getIntent().getStringExtra("to"))) {
					Collections.reverse(linesmap);
					frm.setText(getIntent().getStringExtra("from"));
					to.setText(getIntent().getStringExtra("to"));
					recyclerview1.setAdapter(new Recyclerview1Adapter(linesmap));
				} else {
					Collections.reverse(linesmap);
					frm.setText(getIntent().getStringExtra("to"));
					to.setText(getIntent().getStringExtra("from"));
					recyclerview1.setAdapter(new Recyclerview1Adapter(linesmap));
				}
			}
		});
		
		_r_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				linear1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.GONE);
				tempste.clear();
				linesmap.clear();
				lines = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				linear1.setVisibility(View.GONE);
				linear3.setVisibility(View.VISIBLE);
				frm.setText(lines.get("from").toString());
				to.setText(lines.get("to").toString());
				stops.setText(String.valueOf((long)(Double.parseDouble(lines.get("stops").toString()))));
				transfers.setText(String.valueOf((long)(lines.get("transferStations").toString().length())));
				tempste.clear();
				linesmap.clear();
				transmap.clear(); // Make sure to clear this too
				temptrans.clear();
				
				// Parse the main response
				lines = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				
				frm.setText(lines.get("from").toString());
				to.setText(lines.get("to").toString());
				stops.setText(String.valueOf((long)(Double.parseDouble(lines.get("stops").toString()))));
				
				// --- Handle Routes ---
				String rawRoute = lines.get("route").toString();
				String cleanedRoute = rawRoute.replace("[", "").replace("]", "").trim();
				String[] routeParts = cleanedRoute.split(",");
				
				for (String s : routeParts) {
					HashMap<String, Object> tempmap = new HashMap<>();
					tempmap.put("station_name", s.trim());
					linesmap.add(tempmap);
				}
				
				// --- Handle Transfer Stations ---
				String rawTrans = lines.get("transferStations").toString();
				// Set text for transfer count
				transfers.setText(String.valueOf(rawTrans.split(",").length)); 
				
				String cleanedTrans = rawTrans.replace("[", "").replace("]", "").trim();
				if (!cleanedTrans.isEmpty()) {
					String[] transParts = cleanedTrans.split(",");
					for (String s : transParts) {
						HashMap<String, Object> transferss = new HashMap<>();
						transferss.put("station_name", s.trim());
						transmap.add(transferss);
					}
				}
				
				recyclerview1.setAdapter(new Recyclerview1Adapter(linesmap));
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
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
		
		if ((getIntent().getStringExtra("from").length() > 0) && (getIntent().getStringExtra("to").length() > 0)) {
			linear1.setVisibility(View.GONE);
			linear3.setVisibility(View.VISIBLE);
			r.startRequestNetwork(RequestNetworkController.GET, "https://detroweb.vercel.app/api/metroroute?from=".concat(getIntent().getStringExtra("from").concat("&to=".concat(getIntent().getStringExtra("to")))), "A", _r_request_listener);
			if (!routes.getString("data", "").equals("")) {
				routesdata = new Gson().fromJson(routes.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("route", getIntent().getStringExtra("from").concat(" ".concat("->".concat(" ".concat(getIntent().getStringExtra("to"))))));
					routesdata.add(_item);
				}
				routes.edit().putString("data", new Gson().toJson(routesdata)).commit();
			} else {
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("route", getIntent().getStringExtra("from").concat(" ".concat("->".concat(" ".concat(getIntent().getStringExtra("to"))))));
					routesdata.add(_item);
				}
				routes.edit().putString("data", new Gson().toJson(routesdata)).commit();
			}
		} else {
			linear1.setVisibility(View.VISIBLE);
			linear3.setVisibility(View.GONE);
		}
		imageview3.setColorFilter(SketchwareUtil.getMaterialColor(MetroroutepgActivity.this, com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		imageview1.setColorFilter(SketchwareUtil.getMaterialColor(MetroroutepgActivity.this, com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		imageview4.setColorFilter(SketchwareUtil.getMaterialColor(MetroroutepgActivity.this, com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
		imageview2.setColorFilter(SketchwareUtil.getMaterialColor(MetroroutepgActivity.this, com.google.android.material.R.attr.colorSecondary), PorterDuff.Mode.MULTIPLY);
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
			LayoutInflater _inflater = getLayoutInflater();
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
			textview1.setText(_data.get((int)_position).get("station_name").toString());
			imageview1.setColorFilter(SketchwareUtil.getMaterialColor(MetroroutepgActivity.this, com.google.android.material.R.attr.colorOnPrimaryContainer), PorterDuff.Mode.MULTIPLY);
			k = 0;
			for(int _repeat70 = 0; _repeat70 < (int)(transmap.size()); _repeat70++) {
				if (_data.get((int)_position).get("station_name").toString().equals(transmap.get((int)k).get("station_name").toString())) {
					cardview1.setRadius((float)100);
					imageview1.setImageResource(R.drawable.icon_transferlg);
					textview2.setVisibility(View.VISIBLE);
				}
				k++;
			}
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
