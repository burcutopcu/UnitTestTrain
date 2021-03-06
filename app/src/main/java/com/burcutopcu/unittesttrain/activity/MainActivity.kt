package com.burcutopcu.unittesttrain.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.burcutopcu.unittesttrain.R
import com.burcutopcu.unittesttrain.adapter.VerticalViewAdapter
import com.burcutopcu.unittesttrain.di.DaggerMainActivityComponent
import com.burcutopcu.unittesttrain.helper.DateHelper
import com.burcutopcu.unittesttrain.model.Pokemon
import com.burcutopcu.unittesttrain.vm.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel
    @Inject
    lateinit var dateHelper: DateHelper

    lateinit var verticalViewAdapter: VerticalViewAdapter
    private lateinit var pokemonList: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder().application(this).build().inject(this)
        mainActivityViewModel.getPokemonList()

        mainActivityViewModel.pokemonListSubject.subscribe {
            pokemonList = it
            pokemonList.forEachIndexed { index, element ->
                val date = dateHelper.formatStringToDate(element.createdAt!!)
                pokemonList[index].createdAt = date
            }
            recycler_view.layoutManager = LinearLayoutManager(this)
            verticalViewAdapter = VerticalViewAdapter(pokemonList)
            recycler_view.adapter = verticalViewAdapter
        }
    }
}
