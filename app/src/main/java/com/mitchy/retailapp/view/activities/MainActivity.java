package com.mitchy.retailapp.view.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mitchy.retailapp.R;
import com.mitchy.retailapp.model.entities.Items;
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
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    EditText textosearch;

    List items = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textosearch = (EditText)findViewById(R.id.searchtext);


        Conectar("");


        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new ItemsAdapter(items);

    }

    public void buttonsearch(View v){
        Conectar(textosearch.getText().toString());
    }


    public void Conectar(String busqueda)  {


        busqueda.replace(" ", "+");
        items.clear();
        //Objetos para consulta
        RequestQueue rqt;


/*
working other
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAjT_DBnBBw5yxr-apKJLcoz-DDS8hiUQY&cx=010253606806676965939:dydldvipetk&exactTerms=1&safe=high&filter=1&sort=offer-price&q=intitle:"+busqueda+"+more:pagemap:offer:price";
*/





        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBIthn_nwNkBBiByXNOJ9cIoU8faCxRpFY&cx=000947829845074785382:f3edmteqeoi&exactTerms=1&safe=high&filter=1&q=intitle:"+ busqueda+"";



/*
mitch
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyBIthn_nwNkBBiByXNOJ9cIoU8faCxRpFY&cx=000947829845074785382:iu8kizqyuwa&exactTerms=1&safe=high&filter=1&sort=offer-price&q=intitle:"+busqueda+"+more:pagemap:offer:price:pricelist";
*/


/*
old
        String url = "https://www.googleapis.com/customsearch/v1?key=AIzaSyAjT_DBnBBw5yxr-apKJLcoz-DDS8hiUQY&cx=010253606806676965939:dydldvipetk&exactTerms=1&safe=high&filter=1&sort=pricing-price&q=intitle:"+busqueda+"+more:pagemap:offer:pricing";
*/


        Context ctx;
        StringRequest strq;
        //fin de objetos consulta

        ctx = MainActivity.this;
        rqt = Volley.newRequestQueue(ctx);

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
        //

        JSONObject jsonobj1 = null;
        try {
            jsonobj1 = new JSONObject(json);
            JSONArray jsonarray = jsonobj1.getJSONArray("items");

            for(int i = 0; i < jsonarray.length(); i++ ){
                JSONObject pagemap2 = jsonarray.getJSONObject(i).getJSONObject("pagemap");
                JSONArray offer = pagemap2.getJSONArray("cse_image");

                String displayshopname1;
                displayshopname1 = jsonarray.getJSONObject(i).getString("htmlSnippet");
/*
                Pattern p = Pattern.compile("\\b\\d+\\b");
*/
                Pattern p=Pattern.compile("KSh\\s[0-9]*.[0-9]*");
                Matcher m = p.matcher(displayshopname1);
                String priceooh="";

                if (m.find()) {
                    MatchResult mr=m.toMatchResult();
                    priceooh=mr.group();
                }


/*
                String dosp2=jsonarray.getJSONObject(i).getString("displayLink");
*/
                Loading loading = new Loading();
                loading.execute(offer.getJSONObject(0).getString("src"),
                        jsonarray.getJSONObject(i).getString("title"),priceooh,
                        jsonarray.getJSONObject(i).getString("displayLink"));

/*
                        jsonarray.getJSONObject(i).getString("htmlSnippet"),
*/




                /*JSONObject pagemap2 = jsonarray.getJSONObject(i).getJSONObject("pagemap");
                JSONArray offer = pagemap2.getJSONArray("cse_image");
                JSONArray product = pagemap2.getJSONArray("metatags");
                Loading loading = new Loading();
                String displayshopname1 = jsonarray.getJSONObject(i).getString("displayLink")
                .replace("www.","");
                String displayshopname = displayshopname1.replace(".com.mx", "");
                loading.execute(offer.getJSONObject(0).getString("src"),
                product.getJSONObject(0).getString("og:title"),
                product.getJSONObject(0).getString("og:site_name"),
                displayshopname);
*/
            }

            Log.d("Json", jsonarray.getJSONObject(0).getString("title") );


            recycler.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }





    //regex for cost
    private static final String CURRENCY_SYMBOLS= "\\p{Sc}\u0024\u060B";
    String tmi;

    public void calc(String[] args) {
        Pattern p = Pattern.compile("[" +CURRENCY_SYMBOLS + "][\\d,]+");

        Matcher m = p.matcher(tmi);

        while (m.find()) {
            System.out.println(m.group());
        }
    }







    private class Loading extends AsyncTask<String, Float, Integer>{

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
