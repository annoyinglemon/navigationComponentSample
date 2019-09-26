package producehero.kurt.assignment.ui.sign.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ActivitySignatureBinding

class SignatureActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = DataBindingUtil.setContentView<ActivitySignatureBinding>(this, R.layout.activity_signature)

        viewBinding.buttonSignCancel.setOnClickListener {
            this.finish()
        }
        viewBinding.buttonSignDone.setOnClickListener {
            this.finish()
        }
        viewBinding.textSignClear.setOnClickListener {
            viewBinding.signaturePad.clear()
        }

    }

}