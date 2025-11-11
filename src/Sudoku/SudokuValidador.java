/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sudoku;

/**
 *
 * @author OCTAVIO MARTINEZ
 */


public class SudokuValidador {
    private int[][] board;
    private QueueManual<String> errores;

    public SudokuValidador(int[][] board) {
        this.board = board;
        this.errores = new QueueManual<>();
    }

    public boolean validar() {
        boolean valido = true;

        // filas
        for (int i = 0; i < 9; i++) {
            if (!validarFila(i)) valido = false;
        }

        // columnas
        for (int j = 0; j < 9; j++) {
            if (!validarColumna(j)) valido = false;
        }

        // subcuadros 3x3
        for (int fila = 0; fila < 9; fila += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!validarSubcuadro(fila, col)) valido = false;
            }
        }

        return valido;
    }

    private boolean validarFila(int fila) {
        StackManual<Integer> stack = new StackManual<>();
        for (int col = 0; col < 9; col++) {
            int valor = board[fila][col];
            if (valor < 1 || valor > 9) {
                errores.enqueue("Fila " + fila + ", Col " + col + ": valor inválido -> " + valor);
                continue; // sigue verificando los demás
            }
            if (stack.contains(valor)) {
                errores.enqueue("Fila " + fila + ": número repetido -> " + valor + " (col " + col + ")");
            } else {
                stack.push(valor);
            }
        }
        return true;
    }

    private boolean validarColumna(int col) {
        StackManual<Integer> stack = new StackManual<>();
        for (int fila = 0; fila < 9; fila++) {
            int valor = board[fila][col];
            if (valor < 1 || valor > 9) {
                errores.enqueue("Columna " + col + ", Fila " + fila + ": valor inválido -> " + valor);
                continue;
            }
            if (stack.contains(valor)) {
                errores.enqueue("Columna " + col + ": número repetido -> " + valor + " (fila " + fila + ")");
            } else {
                stack.push(valor);
            }
        }
        return true;
    }

    private boolean validarSubcuadro(int filaInicio, int colInicio) {
        StackManual<Integer> stack = new StackManual<>();
        for (int i = filaInicio; i < filaInicio + 3; i++) {
            for (int j = colInicio; j < colInicio + 3; j++) {
                int valor = board[i][j];
                if (valor < 1 || valor > 9) {
                    errores.enqueue("Subcuadro [" + filaInicio + "," + colInicio + "] pos (" + i + "," + j + "): valor inválido -> " + valor);
                    continue;
                }
                if (stack.contains(valor)) {
                    errores.enqueue("Subcuadro [" + filaInicio + "," + colInicio + "]: número repetido -> " + valor + " (pos " + i + "," + j + ")");
                } else {
                    stack.push(valor);
                }
            }
        }
        return true;
    }

    public void mostrarErrores() {
        if (errores.isEmpty()) {
            System.out.println("No se detectaron errores.");
            return;
        }
        System.out.println("Errores detectados:");
        while (!errores.isEmpty()) {
            System.out.println("- " + errores.dequeue());
        }
    }
}

