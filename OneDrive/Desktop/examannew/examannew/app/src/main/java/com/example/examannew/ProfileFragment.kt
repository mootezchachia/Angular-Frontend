package com.example.examannew

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ProfileFragment : Fragment() {

    private lateinit var txtFullName: TextView
    private lateinit var txtFullemail: TextView

    private var btnSubmit: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.fragment_profile, container, false)
        txtFullName = rootView.findViewById(R.id.txtFullName)
        txtFullemail = rootView.findViewById(R.id.email)
        btnSubmit = rootView.findViewById(R.id.btnSubmit)
        txtFullName.isEnabled = false
        txtFullemail.isEnabled = false
        val name = requireArguments().getString(fullname,"NULL")
        val email = requireArguments().getString(emailfull,"NULL")
        txtFullName.text = " $name"

        txtFullemail.text = "Compte Etudiant"
        btnSubmit!!.setOnClickListener {v ->
             val intent = Intent(v.context, MainActivity::class.java)

             v.context.startActivity(intent)
        }

        return rootView
    }

    companion object {

        @JvmStatic
        fun newInstance(full: String,email :String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(fullname, full)
                    putString(emailfull, email)

                }
            }
    }
}