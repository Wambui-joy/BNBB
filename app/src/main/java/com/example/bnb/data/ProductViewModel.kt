package com.example.bnb.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.bnb.navigation.ADD_PRODUCTS_URL
import com.example.bnb.navigation.ROUT_LOGIN
import com.example.propertyplus.models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class ProductViewModel(val navController: NavController, val context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadProduct(name:String, quantity:String, price:String, phone: String,filePath: Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Products/$productId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    val imageUrl = it.toString()
                    val product = Product(name,quantity,price,phone,imageUrl,productId)
                    val databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Products/$productId")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allProducts(
        product: MutableState<Product>,
        products: SnapshotStateList<Product>):SnapshotStateList<Product>{
        progress.show()
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Products")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (snap in snapshot.children){
                    val retrievedProduct = snap.getValue(Product::class.java)
                    product.value = retrievedProduct!!
                    products.add(retrievedProduct)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }

    fun updateProduct(productId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Products/$productId")
        ref.removeValue()
        navController.navigate(ADD_PRODUCTS_URL)
    }


    fun deleteProduct(productId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Products/$productId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}