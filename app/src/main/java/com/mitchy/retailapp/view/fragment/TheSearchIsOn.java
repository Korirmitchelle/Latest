package com.mitchy.retailapp.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mitchy.retailapp.R;
import com.mitchy.retailapp.model.entities.Items;
import com.mitchy.retailapp.model.entities.Product;
import com.mitchy.retailapp.util.Utils;
import com.mitchy.retailapp.view.activities.ECartHomeActivity;
import com.mitchy.retailapp.view.adapter.ItemsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class TheSearchIsOn extends Fragment {

    //from before
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;



    private static final int REQ_SCAN_RESULT = 200;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    ArrayList<Product> searchProductList = new ArrayList<>();
    boolean searchInProgress = false;
    private TextView heading;
    private ImageButton btnSpeak;
    private EditText serchInput;
    private ListView serachListView;
    List items = new ArrayList();


    /** The search adapter. */
    // private SearchListArrayAdapter searchAdapter;
    /**
     * The root view.
     */
    private View rootView;

    public static Fragment newInstance() {
        // TODO Auto-generated method stub
        return new SearchProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_the_search_is_on,
                container, false);

        btnSpeak = (ImageButton) rootView.findViewById(R.id.btnSpeak);

        heading = (TextView) rootView.findViewById(R.id.txtSpeech_heading);

        serchInput = (EditText) rootView.findViewById(R.id.edt_search_input);

        serchInput.setSelected(true);




/*
        replaced with recyclerview
*/

        /*serachListView = (ListView) rootView
                .findViewById(R.id.search_list_view);

        serachListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getActivity(), "Selected" + position, 500)
                        .show();

            }
        });
*/


        serchInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence inputString, int arg1,
                                      int arg2, int arg3) {

                heading.setText("Showing results for "
                        + inputString.toString().toLowerCase());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

                heading.setText("Search Products");

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    Utils.switchContent(R.id.frag_container,
                            Utils.HOME_FRAGMENT,
                            ((ECartHomeActivity) (getContext())),
                            Utils.AnimationType.SLIDE_DOWN);
                }
                return true;
            }
        });



        //prescvious

        Conectar("");
        // Obtener el Recycler
        recycler = (RecyclerView)getActivity().findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new ItemsAdapter(items);
        Conectar(serchInput.getText().toString());
        return rootView;






    }

   /* public void buttonsearch(View v){
        Conectar(textosearch.getText().toString());
    }*/






    public void Conectar(String busqueda)  {


        busqueda.replace(" ", "+");
        items.clear();
        //Objetos para consulta
        RequestQueue rqt;


/*
working other
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAjT_DBnBBw5yxr-apKJLcoz-DDS8hiUQY&cx=010253606806676965939:dydldvipetk&exactTerms=1&safe=high&filter=1&sort=offer-price&q=intitle:"+busqueda+"+more:pagemap:offer:price";
*/


        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyDlinGLhmSlCG5EUSY2aOm1B6FE1J05Qi0&cx=000947829845074785382:iu8kizqyuwa&exactTerms=1&safe=high&filter=1&q=intitle:"+ busqueda+"";

/*
mitch
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBIthn_nwNkBBiByXNOJ9cIoU8faCxRpFY&cx=000947829845074785382:iu8kizqyuwa&exactTerms=1&safe=high&filter=1&sort=offer-price&q=intitle:"+busqueda+"+more:pagemap:offer:price:pricelist";
*/


/*
old
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAjT_DBnBBw5yxr-apKJLcoz-DDS8hiUQY&cx=010253606806676965939:dydldvipetk&exactTerms=1&safe=high&filter=1&sort=pricing-price&q=intitle:"+busqueda+"+more:pagemap:offer:pricing";
*/


/*
        Context ctx;
*/
        StringRequest strq;
        //fin de objetos consulta


        rqt = Volley.newRequestQueue(getActivity().getApplicationContext());


       /* ctx = MainActivity.this;
        rqt = Volley.newRequestQueue(ctx);*/

        strq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                //Log.d("Servidor", response);
                ManejarJson(response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                NetworkResponse errorRes = error.networkResponse;
                Log.d("Servidor Error", errorRes.statusCode+"");

                String stringData = "";
                if(errorRes != null && errorRes.data != null){
                    stringData = new String(errorRes.data);
                }
                Log.e("Error",stringData);

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> parametros = new HashMap<>();
                //parametros.put("email", email);
                //parametros.put("password", password);



                return checkParams(parametros);
            }

        };
        rqt.add(strq);
    }





    /**
     * Showing google speech input dialog.
     */
    private void promptSpeechInput() {
        searchInProgress = true;
        searchProductList.clear();

        heading.setText("Search Products");

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What do you wish for");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity(),
                    "Voice search not supported by your device ",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input.
     *
     * @param requestCode the request code
     * @param resultCode  the result code
     * @param data        the data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        searchInProgress = false;

        if (resultCode == getActivity().RESULT_OK && null != data) {
            switch (requestCode) {
                case REQ_CODE_SPEECH_INPUT: {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    heading.setText("Showing Results for " + result.get(0));

                    break;
                }

                case REQ_SCAN_RESULT:
                    //
                    // String contents = data.getStringExtra("SCAN_RESULT");
                    // String format = data.getStringExtra("SCAN_RESULT_FORMAT");
                    // Toast.makeText(getActivity(), "Scan Success", 1000).show();
                    break;

            }

        }

    }
/*mine*/

    private Map<String, String> checkParams(Map<String, String> map){
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
            if(pairs.getValue()==null){
                map.put(pairs.getKey(), "");
            }
        }
        return map;
    }

    public void ManejarJson(String json){
        JSONObject jsonobj1 = null;
        try {
            jsonobj1 = new JSONObject(json);
            JSONArray jsonarray = jsonobj1.getJSONArray("items");

            for(int i = 0; i < jsonarray.length(); i++ ){


                JSONObject pagemap2 = jsonarray.getJSONObject(i).getJSONObject("pagemap");
                JSONArray offer = pagemap2.getJSONArray("cse_image");
                JSONArray product = pagemap2.getJSONArray("metatags");
                Loading loading = new Loading();
                String displayshopname1 = jsonarray.getJSONObject(i).getString("displayLink").replace("www.","");
                String displayshopname = displayshopname1.replace(".com.mx", "");
                loading.execute(offer.getJSONObject(0).getString("src"), product.getJSONObject(0).getString("og:title"), product.getJSONObject(0).getString("og:site_name"), displayshopname);

            }

            Log.d("Json", jsonarray.getJSONObject(0).getString("title") );


            recycler.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }



    private class Loading extends AsyncTask<String, Float, Integer> {

        protected void onPreExecute() {
        }

        protected Integer doInBackground(String... datos) {


            Drawable d = null;
            try
            {
                InputStream is = (InputStream) new URL(datos[0]).getContent();
                d = Drawable.createFromStream(is, "src name");

            }catch (Exception e) {
                System.out.println("Exc="+e);
            }
            items.add(new Items(d, datos[1],datos[2], datos[3]));



            return 250;
        }

        protected void onProgressUpdate (Float... valores) {
            int p = Math.round(100*valores[0]);
            Log.d("Carga", ""+p);
        }

        protected void onPostExecute(Integer bytes) {
            recycler.setAdapter(adapter);
        }
    }




}
