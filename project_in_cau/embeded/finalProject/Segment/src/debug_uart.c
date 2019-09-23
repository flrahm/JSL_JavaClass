/*
 * debug_uart.c
 *
 *  Created on: 2016. 4. 15.
 *      Author: YDCHEONG
 */

#include <ansi_color.h>
//#include <hal_falcon.h>
#include <stdio.h>
#include <stdarg.h>



void dbg_sendString(char * str)
{
	while(*str!=0)
	{
		SerialPutChar(*str++);
	}
}

void dbg_printf(char *fmt,...)
{
	va_list ap;
	char string[256];

	va_start(ap,fmt);
	vsprintf(string,fmt,ap);
	dbg_sendString(string);
	va_end(ap);
}

/* 터미널에 노란색으로 출력 */
void dbg_printfColor(char * color, char * fmt, ...)
{
	va_list ap;
	char string[256];

	va_start(ap,fmt);
	vsprintf(string,fmt,ap);
	dbg_sendString(color);
	dbg_sendString(string);
	dbg_sendString(ANSI_TEXT_RESET);
	va_end(ap);
}
