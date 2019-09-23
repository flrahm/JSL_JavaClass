/*
 * (C) COPYRIGHT 2009 CRZ
 *
 * File Name : seven_segment.c
 * Author    : POOH
 * Version   : V1.0
 * Date      : 08/20/2009
 */

/* Includes */

#include "hw_config.h"

/* functions */

void PowerOn_7_SEG(void)
{
    GPIO_7_SEG->BRR |= GPIO_7_SEG_POWER_PIN;
}

void PowerOff_7_SEG(void)
{
    GPIO_7_SEG->BSRR |= GPIO_7_SEG_POWER_PIN;
}

void On_7_SEG_OnePin(uint16_t pinNum)
{
    GPIO_7_SEG->BRR |= pinNum;
}

void Off_7_SEG_OnePin(uint16_t pinNum)
{
    GPIO_7_SEG->BSRR |= pinNum;
}

void On_7_SEG_AllPin(void)
{
    On_7_SEG_OnePin
        (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
         | GPIO_7_SEG_D_PIN | GPIO_7_SEG_E_PIN | GPIO_7_SEG_F_PIN
         | GPIO_7_SEG_G_PIN | GPIO_7_SEG_DP_PIN);
}

void Off_7_SEG_AllPin(void)
{
    Off_7_SEG_OnePin
        (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
         | GPIO_7_SEG_D_PIN | GPIO_7_SEG_E_PIN | GPIO_7_SEG_F_PIN
         | GPIO_7_SEG_G_PIN | GPIO_7_SEG_DP_PIN);
}

void OutPut_7_SEG_Number(unsigned int num)
{
    Off_7_SEG_AllPin();

    switch(num)
    {
    case 0:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_D_PIN | GPIO_7_SEG_E_PIN | GPIO_7_SEG_F_PIN);
        break;

    case 1:
        On_7_SEG_OnePin
            (GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN);
        break;

    case 2:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_D_PIN
            | GPIO_7_SEG_E_PIN | GPIO_7_SEG_G_PIN);
        break;

    case 3:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_D_PIN | GPIO_7_SEG_G_PIN);
        break;

    case 4:
        On_7_SEG_OnePin
            (GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_F_PIN | GPIO_7_SEG_G_PIN);
        break;

    case 5:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_C_PIN | GPIO_7_SEG_D_PIN
            | GPIO_7_SEG_F_PIN | GPIO_7_SEG_G_PIN);
        break;

    case 6:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_C_PIN | GPIO_7_SEG_D_PIN
            | GPIO_7_SEG_E_PIN | GPIO_7_SEG_F_PIN | GPIO_7_SEG_G_PIN);
        break;

    case 7:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_F_PIN);
        break;

    case 8:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_D_PIN | GPIO_7_SEG_E_PIN | GPIO_7_SEG_F_PIN
            | GPIO_7_SEG_G_PIN);
        break;

    case 9:
        On_7_SEG_OnePin
            (GPIO_7_SEG_A_PIN | GPIO_7_SEG_B_PIN | GPIO_7_SEG_C_PIN
            | GPIO_7_SEG_D_PIN | GPIO_7_SEG_F_PIN | GPIO_7_SEG_G_PIN);
        break;
    }
}

