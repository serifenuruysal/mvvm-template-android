package com.androidapp.template.presentation.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.androidapp.template.R
import com.androidapp.template.presentation.adapter.ModelClickEvent
import com.androidapp.template.presentation.rx.RxBus
import com.androidapp.template.presentation.util.addFragment
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var subscribeClickEvent: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (fragmentsContainer != null) {
            if (savedInstanceState != null) {
                return
            }
            addFragment(R.id.fragmentsContainer, FirstFragment(), true)
        }

        subscribeObservable()
    }

    private fun subscribeObservable() {

        subscribeClickEvent =
            RxBus.listen(ModelClickEvent::class.java).subscribe {

            }
    }
    private fun unSubscribeObservable() {
        if (!subscribeClickEvent.isDisposed) {
            subscribeClickEvent.dispose()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unSubscribeObservable()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
