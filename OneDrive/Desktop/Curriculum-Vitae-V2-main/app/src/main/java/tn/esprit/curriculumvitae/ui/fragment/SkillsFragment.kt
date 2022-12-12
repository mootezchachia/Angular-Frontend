package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.slider.Slider
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.ui.activity.SKILL_ANDROID
import tn.esprit.curriculumvitae.ui.activity.SKILL_FLUTTER
import tn.esprit.curriculumvitae.ui.activity.SKILL_IOS

class SkillsFragment : Fragment() {

    private lateinit var sliderAndroid: Slider
    private lateinit var sliderIos: Slider
    private lateinit  var sliderFlutter: Slider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView :View = inflater.inflate(R.layout.fragment_skills, container, false)

        sliderAndroid = rootView.findViewById(R.id.seekBarAndroid)
        sliderIos = rootView.findViewById(R.id.seekBarIos)
        sliderFlutter = rootView.findViewById(R.id.seekBarFlutter)

        sliderAndroid.isEnabled = false
        sliderIos.isEnabled = false
        sliderFlutter.isEnabled = false

        sliderAndroid.value = requireArguments().getFloat(SKILL_ANDROID,0.0F)
        sliderIos.value = requireArguments().getFloat(SKILL_IOS,0.0F)
        sliderFlutter.value = requireArguments().getFloat(SKILL_FLUTTER,0.0F)

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(skillAndroid: Float, skillIOS: Float, skillFlutter: Float) = SkillsFragment().apply {
            arguments = Bundle().apply {
                putFloat(SKILL_ANDROID, skillAndroid)
                putFloat(SKILL_IOS, skillIOS)
                putFloat(SKILL_FLUTTER, skillFlutter)
            }
        }
    }
}