package com.burcutopcu.unittesttrain.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.burcutopcu.unittesttrain.R
import com.burcutopcu.unittesttrain.adapter.VerticalViewAdapter
import com.burcutopcu.unittesttrain.di.DaggerMainActivityComponent
import com.burcutopcu.unittesttrain.vm.MainActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var verticalViewAdapter: VerticalViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder().application(this).build().inject(this)
        mainActivityViewModel.getPokemonList()

        mainActivityViewModel.pokemonListSubject.subscribe {
            recycler_view.layoutManager = LinearLayoutManager(this)
            verticalViewAdapter = VerticalViewAdapter(it)
            recycler_view.adapter = verticalViewAdapter
        }
    }
}
