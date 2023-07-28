package com.isil.pregunta1;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtCodigo, txtNombre;
    private Button addButton;
    private ListView listViewProductos;
    private ArrayList<Producto> productList;
    private ProductoAdapter productAdapter;
    private static final int MAX_PRODUCTS = 5; // Máximo 5 productos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar variables
        txtCodigo = findViewById(R.id.editTextCode);
        txtNombre = findViewById(R.id.editTextName);
        addButton = findViewById(R.id.addButton);
        listViewProductos = findViewById(R.id.listViewProducts);
        productList = new ArrayList<>();
        productAdapter = new ProductoAdapter(this, productList);

        // Configurar el adaptador para el ListView
        listViewProductos.setAdapter(productAdapter);

        // Agregar evento al botón "Agregar producto"
        addButton.setOnClickListener(v -> addProductToList());
    }

    // Método para agregar un producto a la lista
    private void addProductToList() {

        //La validacion para 5 productos
        if (productList.size() >= MAX_PRODUCTS) {
            Toast.makeText(this, "No se pueden agregar más de " + MAX_PRODUCTS + " productos.", Toast.LENGTH_SHORT).show();
            return;
        }
        String codigo = txtCodigo.getText().toString().trim();
        String name = txtNombre.getText().toString().trim();

        if (codigo.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa todos los datos del producto.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear un nuevo objeto de tipo Product y agregarlo a la lista
        Producto product = new Producto(codigo, name);
        productList.add(product);

        // Actualizar el ListView
        productAdapter.notifyDataSetChanged();

        // Limpiar los campos de entrada
        txtCodigo.getText().clear();
        txtNombre.getText().clear();

    }
}
