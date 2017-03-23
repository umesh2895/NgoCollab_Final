package com.ngocollab.event;

import android.support.v4.app.Fragment;

/**
 * Created by Belal on 2/3/2016.
 */

public class FragmentPhotos extends Fragment {

//    //Declarations=====================
//    private String TAG = "Glide Photos Tab";
//
//    private static final String GET_IMAGES_URL = "http://192.168.1.2/AndroidUploadImage/GetStoredEventImages.php"; //this url creates result json where all images related to events are present
//    //in the form of links... JSON is parsed by GLIDE gallery library
//
//    String endpoint = "http://192.168.1.2/AndroidUploadImage/results.json";//php site here if available
//    private ArrayList<Image> images;
//    //private ProgressDialog pDialog;
//    private ProgressBar pBar;
//    private GalleryAdapter mAdapter;
//    private RecyclerView recyclerView;
//    SwipeRefreshLayout mSwipeRefreshLayout;
//    private TextView refreshHintText;
//    //=================================
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView=inflater.inflate(R.layout.event_tab2, container, false);
//        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
//        mSwipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipe_refresh_layout);
//        refreshHintText = (TextView)rootView.findViewById(R.id.refreshHintTextView);
//
//        pBar= (ProgressBar)rootView.findViewById(R.id.progress_image_loading);
//        //pDialog = new ProgressDialog(getActivity());
//        images = new ArrayList<>();
//        mAdapter = new GalleryAdapter(getActivity().getApplicationContext(), images);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//
//        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("images", images);
//                bundle.putInt("position", position);
//
//                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
//                newFragment.setArguments(bundle);
//                newFragment.show(ft, "slideshow");
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
//
//        //swipe to refresh
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getImageUrlInJSON();
//            }
//        });
//
//        return rootView;
//    }
//
//    private void fetchImages() {
//
//        pBar.setVisibility(View.VISIBLE);
//        mSwipeRefreshLayout.setRefreshing(false);
//
//        JsonArrayRequest req = new JsonArrayRequest(endpoint,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.d(TAG, response.toString());
//
//                        images.clear();
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//
//                                Image image = new Image();
//
//                                JSONObject url = object.getJSONObject("url");
//
//                                image.setMedium(url.getString("medium"));
//
//                                images.add(image);
//
//                            } catch (JSONException e) {
//                                Log.e(TAG, "Json parsing error: " + e.getMessage());
//                                pBar.setVisibility(View.GONE);
//                                mSwipeRefreshLayout.setRefreshing(false);
//                                Toast.makeText(getActivity(), "Sorry...Unknown Error !!!", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//
//
//                        mAdapter.notifyDataSetChanged();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getActivity(), "Network might not be available !!!", Toast.LENGTH_SHORT).show();
//                mSwipeRefreshLayout.setRefreshing(false);
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(req);
//        pBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            //call here something which you wanted to load only when user clicks on this tab (fragment)
//
//        }else{
//            // fragment is no longer visible
//        }
//    }
//
//    private void getImageUrlInJSON() {
//
//
//        pBar.setVisibility(View.VISIBLE);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_IMAGES_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        fetchImages();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        mSwipeRefreshLayout.setRefreshing(false);
//                        pBar.setVisibility(View.GONE);
//
//                        if (error instanceof NoConnectionError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"No Connection. Please Turn on Internet...", Toast.LENGTH_SHORT).show();
//                        }
//                        else if (error instanceof TimeoutError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"Time out error...", Toast.LENGTH_SHORT).show();
//                        } else if (error instanceof AuthFailureError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"Authentication Failure...", Toast.LENGTH_SHORT).show();
//                        } else if (error instanceof ServerError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"Server may not be available...", Toast.LENGTH_SHORT).show();
//                        } else if (error instanceof NetworkError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"Network error...", Toast.LENGTH_SHORT).show();
//                        } else if (error instanceof ParseError) {
//                            Toast.makeText(getActivity().getApplicationContext(),"Parse error...", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }){
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("eventid","BloodDonation0013"); //eventid i.e. first parameter must be same to eventid variable used in php
//                return params;
//            }
//
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
//        requestQueue.add(stringRequest);
//    }
}
