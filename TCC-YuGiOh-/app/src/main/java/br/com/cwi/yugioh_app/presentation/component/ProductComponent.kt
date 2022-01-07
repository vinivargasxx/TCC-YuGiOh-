package br.com.cwi.yugioh_app.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.ComponentProductBinding

class ProductComponent : ConstraintLayout {

    private var binding: ComponentProductBinding =
        ComponentProductBinding.inflate(LayoutInflater.from(context), this)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        context.obtainStyledAttributes(
            attrs, R.styleable.ProductComponent, 0, 0
        ).run {
            binding.run {
                title = getString(
                    R.styleable.ProductComponent_component_product_title
                )
                subtitle = getString(
                    R.styleable.ProductComponent_component_product_subtitle
                )
                ivProductImage.setImageDrawable(
                    getDrawable(
                        R.styleable.ProductComponent_component_product_image
                    )
                )
                setBackgroundColor(
                    getColor(
                        R.styleable.ProductComponent_component_product_background_color,
                        ContextCompat.getColor(context, R.color.cards_color)
                    )
                )
            }
            recycle()
        }
    }

    var subtitle:String? = null
        set(value) {
            field = value
            binding.tvProductSubtitle.text = value
        }

    var title: String? = null
        set(value) {
            field = value
            binding.tvProductTitle.text = value
        }
}