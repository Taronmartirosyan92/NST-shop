package com.example.armen.mynoutbook.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.armen.mynoutbook.CategoryEnum.Category;
import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.adapters.PrAdapter;
import com.example.armen.mynoutbook.providers.PrProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    private RecyclerView recyclerView;
    private PrAdapter adapter;
    private SearchView searchView;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_product, container, false);
        adapter = new PrAdapter(getContext(), PrProvider.getPrList(getContext()));
        recyclerView = view.findViewById(R.id.pr_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void updateAdapter() {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void upDaListData(Enum<Category> category) {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByCategory(category)));
    }

    public void setListByFavorite() {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByFavorite()));
    }

    public void setListByCard() {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByCard()));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search_id);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }
}


