package com.jm.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),     // 예: 태그, 배지
    small = RoundedCornerShape(8.dp),          // 예: 버튼, TextField
    medium = RoundedCornerShape(12.dp),        // 예: 카드, 다이얼로그
    large = RoundedCornerShape(16.dp),         // 예: 하단 시트, 모달
    extraLarge = RoundedCornerShape(28.dp)     // 예: 둥글게 처리된 화면 요소
)
