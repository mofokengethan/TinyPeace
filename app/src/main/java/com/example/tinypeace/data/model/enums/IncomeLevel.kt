package com.example.tinypeace.model.enums

enum class IncomeLevel(val emoji: String, val description: String) {
    BELOW_50K("💵", "Below $50k"),
    FROM_50K_TO_60K("💵", "$50k - $60k"),
    FROM_60K_TO_70K("💵", "$60k - $70k"),
    FROM_70K_TO_80K("💵💵", "$70k - $80k"),
    FROM_80K_TO_90K("💵💵", "$80k - $90k"),
    FROM_90K_TO_100K("💵💵", "$90k - $100k"),
    FROM_100K_TO_200K("💵💵💵", "$100k - $200k"),
    FROM_200K_TO_500K("💵💵💵", "$200k - $500k"),
    FROM_500K_TO_1M("💵💵💵", "$500k - $1M"),
    FROM_1M_TO_2M("💵💵💵💵", "$1M - $2M"),
    FROM_2M_TO_5M("💵💵💵💵", "$2M - $5M"),
    ABOVE_5M("💵💵💵💵💵", "Above $5M")
}
