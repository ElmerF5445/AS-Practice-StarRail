package com.example.starrail;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link panel_trips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class panel_trips extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public panel_trips() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment panel_trips.
     */
    // TODO: Rename and change types and number of parameters
    public static panel_trips newInstance(String param1, String param2) {
        panel_trips fragment = new panel_trips();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_panel_trips, container, false);
        RecyclerView Lister = parent.findViewById(R.id.Lister);
        Lister.setLayoutManager(new LinearLayoutManager(parent.getContext()));
        List<model_trip> TripData = new ArrayList<>();
        TripData.add(new model_trip("Marikina Heights",  "Fr: SNMT-GBYN1 | To: MRKN-HGHTS", 20.50));
        TripData.add(new model_trip("Guitnangbayan 1",  "Fr: MRKN-HGHTS | To: SNMT-GBYN1", 25.50));
        TripData.add(new model_trip("Concepcion Uno",  "Fr: SNMT-GBYN1 | To: MRKN-CCPN1", 25.50));
        TripData.add(new model_trip("Marikina Bayan",  "Fr: SNMT-GBYN1 | To: MRKN-BAYAN", 35.50));
        TripData.add(new model_trip("Riverbanks",  "Fr: SNMT-GBYN1 | To: MRKN-RVBKS", 35.50));
        TripData.add(new model_trip("OMV Dijiang Bridge",  "Fr: SNMT-GBYN1 | To: ODJG-BRDGE", 923.50));
        adapter_trip List_Adapter = new adapter_trip(TripData, new adapter_trip.OnTripClickListener(){
            public void onTripClick(model_trip event){
                OpenInfo(event);
            }
        });
        Lister.setAdapter(List_Adapter);
        return parent;
    }

    public void OpenInfo(model_trip Data){
        Intent intent = new Intent(getContext(), trip_info.class);
        intent.putExtra("TRIP_INFO", Data);
        startActivity(intent);
    }
}