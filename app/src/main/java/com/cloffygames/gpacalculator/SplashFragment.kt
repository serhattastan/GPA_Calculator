package com.cloffygames.gpacalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cloffygames.gpacalculator.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        // SharedPreferences'a bağlan.
        val preferences =
            requireActivity().getSharedPreferences("com.cloffygames.gpacalculator", Context.MODE_PRIVATE)

        // İlk defa açılma bilgisini al.
        val checkFirstOpen = preferences.getBoolean("check_first_open", true)

        binding.apply {
            // ImageView'ın alpha değerini sıfıra ayarla.
            imageView.alpha = 0f
            // ImageView'ın alpha değerini 1'e animasyonlu bir şekilde artır.
            imageView.animate().setDuration(1500).alpha(1f).withEndAction {

                if (checkFirstOpen) {
                    // İlk defa açılma bilgisini güncelle.
                    preferences.edit().putBoolean("check_first_open", false).apply()
                    // Uygulama ilk defa açıldıysa .... ekranına git.
                } else {
                    // Ana ekrana git.
                    goHomeActivity()
                }

                // Geçiş efektini uygula.
                activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                // Aktiviteyi kapat.
                activity?.finish()
            }

            // TextView'ın alpha değerini sıfıra ayarla.
            textView2.alpha = 0f
            // TextView'ın alpha değerini 1'e animasyonlu bir şekilde artır.
            textView2.animate().setDuration(1500).alpha(1f)
        }

        return binding.root
    }

    // Ana erkana gidiş fonksiyonu.
    fun goHomeActivity() {
        val transition = SplashFragmentDirections.actionSplashFragmentToMainActivity()
        Navigation.findNavController(requireView()).navigate(transition)
    }

}