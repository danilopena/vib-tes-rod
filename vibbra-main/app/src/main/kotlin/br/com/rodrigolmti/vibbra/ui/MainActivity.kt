package br.com.rodrigolmti.vibbra.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.rodrigolmti.vibbra.R
import br.com.rodrigolmti.vibbra.core.view_binding_delegate.viewBinding
import br.com.rodrigolmti.vibbra.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navHostFragment: NavHostFragment? by lazy {
        supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}