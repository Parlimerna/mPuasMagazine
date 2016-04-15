package com.magazine.puas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joanzapata.pdfview.PDFView;

public class DisplayFragment extends Fragment {

    public static DisplayFragment newInstance(String title) {
        return new DisplayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_page, container, false);

        /*String  pdfName = "dummy.pdf";
        PDFView pdfView = (PDFView) view.findViewById(R.id.pdfview);
        pdfView.fromAsset(pdfName)
                .defaultPage(0)
                .swipeVertical(true)
                .showMinimap(true)
                .enableSwipe(true)
                .load();*/

        return view;
    }
}
