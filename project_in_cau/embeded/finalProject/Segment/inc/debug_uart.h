/*
 * debug_uart.h
 *
 *  Created on: 2016. 5. 16.
 *      Author: YDCHEONG
 */

#ifndef DEBUG_UART_H_
#define DEBUG_UART_H_

#include <ansi_color.h>
#include <stdbool.h>
#include <stdint.h>

/* Debug UART I/O function */
extern void SerialPutChar(uint8_t c);
extern void Serial_PutString(uint8_t *s);

extern void dbg_printf(char *fmt,...);
extern void dbg_printfColor(char * color, char * fmt, ...);

#endif /* DEBUG_UART_H_ */
