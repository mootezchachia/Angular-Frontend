package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import tn.esprit.curriculumvitae.ui.activity.IS_ARABIC
import tn.esprit.curriculumvitae.ui.activity.IS_ENGLISH
import tn.esprit.curriculumvitae.ui.activity.IS_FRENCH
import tn.esprit.curriculumvitae.R


class LanguageFragment : Fragment() {

    private lateinit var cbFrench : CheckBox
    private lateinit var cbEnglish : CheckBox
    private lateinit var cbArabic : CheckBox

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView :View = inflater.inflate(R.layout.fragment_language, container, false)

        cbFrench = rootView.findViewById(R.id.cbFrench)
        cbEnglish = rootView.findViewById(R.id.cbEnglish)
        cbArabic = rootView.findViewById(R.id.cbArabic)

        cbFrench.isEnabled = false
        cbEnglish.isEnabled = false
        cbArabic.isEnabled = false

        cbFrench.isChecked = requireArguments().getBoolean(IS_FRENCH,false)
        cbEnglish.isChecked = requireArguments().getBoolean(IS_ENGLISH,false)
        cbArabic.isChecked = requireArguments().getBoolean(IS_ARABIC,false)

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(isArabic: Boolean, isFrench: Boolean, isEnglish: Boolean) = LanguageFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_ARABIC, isArabic)
                putBoolean(IS_FRENCH, isFrench)
                putBoolean(IS_ENGLISH, isEnglish)
            }
        }
    }
}