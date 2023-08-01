/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchGUI;

/**
 *
 * @author Morad
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinarySearchGUI extends JFrame implements ActionListener {

    private JTextField[] inputFields;
    private JButton searchButton;
    private JTextArea resultArea;

    private int[] lista;

    public BinarySearchGUI() {
        setTitle("Búsqueda Binaria");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingrese los elementos de la lista en orden ascendente:");
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el tamaño de la lista:"));
        inputFields = new JTextField[tamanio];

        for (int i = 0; i < tamanio; i++) {
            inputFields[i] = new JTextField(5);
            inputPanel.add(inputFields[i]);
        }

        searchButton = new JButton("Buscar");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        panel.add(label, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.SOUTH);

        searchButton.addActionListener(this);

        add(panel);

        setVisible(true);
    }

    private int busquedaBinaria(int target) {
        int indiceIzq = 0;                      // Índice izquierdo inicial
        int indiceDer = lista.length - 1;       // Índice derecho inicial

        while (indiceIzq <= indiceDer) {        // Bucle que se ejecuta mientras el espacio de búsqueda sea válido
            int indiceMedio = indiceIzq + (indiceDer - indiceIzq) / 2; // Índice medio del espacio de búsqueda

            if (lista[indiceMedio] == target) {  // Si el elemento en el índice medio es igual al objetivo
                return indiceMedio;             // Se encontró el elemento objetivo, devuelve el índice medio
            } else if (lista[indiceMedio] < target) { // Si el elemento en el índice medio es menor que el objetivo
                indiceIzq = indiceMedio + 1;    // Se descarta la mitad izquierda del espacio de búsqueda
            } else {                            // Si el elemento en el índice medio es mayor que el objetivo
                indiceDer = indiceMedio - 1;    // Se descarta la mitad derecha del espacio de búsqueda
            }
        }

        // Si el bucle termina y no se encontró el elemento, devuelve -1
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista = new int[inputFields.length];

        for (int i = 0; i < inputFields.length; i++) {
            lista[i] = Integer.parseInt(inputFields[i].getText());
        }

        int target = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número que desea buscar:"));

        int resultado = busquedaBinaria(target);
        if (resultado != -1) {
            resultArea.setText("El número " + target + " se encuentra en el índice " + resultado + " de la lista.");
        } else {
            resultArea.setText("El número " + target + " no fue encontrado en la lista.");
        }

        JOptionPane.showMessageDialog(this, new JScrollPane(resultArea), "Resultado de la búsqueda", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BinarySearchGUI());
    }
}
