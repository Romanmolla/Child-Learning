package com.roman.clildlearning
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.roman.clildlearning.databinding.ActivityProfileBinding
import com.roman.clildlearning.model.UserModel

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    lateinit var profileUserId : String
    lateinit var currentUserId : String
    lateinit var photoLauncher: ActivityResultLauncher<Intent>


    private lateinit var profileUserModel : UserModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        profileUserId = intent.getStringExtra("profile_user_id")!!
        currentUserId =  FirebaseAuth.getInstance().currentUser?.uid!!

        photoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
//            if(result.resultCode == RESULT_OK){
//                uploadToFirestorm(result.data?.data!!)
//            }
        }

//        if(profileUserId==currentUserId){
//            //CUrrent user profile
//            binding.profileBtn.text = "Logout"
//            binding.profileBtn.setOnClickListener {
//                logout()
//            }
////            binding.profilePic.setOnClickListener {
////                checkPermissionAndPickPhoto()
//            }
//        }else{
//            binding.profileBtn.text = "Follow"
//            binding.profileBtn.setOnClickListener {
//                followUnfollowUser()
//            }
//        }
//        getProfileDataFromFirebase()
//    }

//    @SuppressLint("SetTextI18n")
//    fun followUnfollowUser(){
//        Firebase.firestore.collection("users")
//            .document(currentUserId)
//            .get()
//            .addOnSuccessListener {
//                val currentUserModel = it.toObject(UserModel::class.java)!!
//                if(profileUserModel.followerList.contains(currentUserId)){
//                    //unfollow user
//                    profileUserModel.followerList.remove(currentUserId)
//                    currentUserModel.followingList.remove(profileUserId)
//                    binding.profileBtn.text = "Follow"
//                }else{
//                    //follow user
//                    profileUserModel.followerList.add(currentUserId)
//                    currentUserModel.followingList.add(profileUserId)
//                    binding.profileBtn.text = "Unfollow"
//                }
//                updateUserData(profileUserModel)
//                updateUserData(currentUserModel)
//
//
//            }


    }

//    private fun updateUserData(model : UserModel){
//        Firebase.firestore.collection("users")
//            .document(model.id)
//            .set(model)
//            .addOnSuccessListener {
//                getProfileDataFromFirebase()
//            }
//    }
//
//    private fun uploadToFirestorm(photoUri : Uri){
//        binding.progressBar.visibility = View.VISIBLE
//        val photoRef =  FirebaseStorage.getInstance()
//            .reference
//            .child("profilePic/$currentUserId")
//        photoRef.putFile(photoUri)
//            .addOnSuccessListener {
//                photoRef.downloadUrl.addOnSuccessListener {downloadUrl->
//                    //video model store in firebase firestore
//                    postToFirestorm(downloadUrl.toString())
//                }
//            }
//    }
//
//    private fun postToFirestorm(url : String){
//        Firebase.firestore.collection("users")
//            .document(currentUserId)
//            .update("profilePic",url)
//            .addOnSuccessListener {
//                getProfileDataFromFirebase()
//            }
//    }


//    private fun checkPermissionAndPickPhoto(){
//        var readExternalPhoto : String = ""
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
//            readExternalPhoto = android.Manifest.permission.READ_MEDIA_IMAGES
//        }else{
//            readExternalPhoto = android.Manifest.permission.READ_EXTERNAL_STORAGE
//        }
//        if(ContextCompat.checkSelfPermission(this,readExternalPhoto)== PackageManager.PERMISSION_GRANTED){
//            //we have permission
//            openPhotoPicker()
//        }else{
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(readExternalPhoto),
//                100
//            )
//        }
//    }

//    @SuppressLint("IntentReset")
//    private fun openPhotoPicker(){
//        val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
//        intent.type = "image/*"
//        photoLauncher.launch(intent)
//    }
//
//
//
//    private fun logout(){
//        FirebaseAuth.getInstance().signOut()
//        val intent = Intent(this,LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
//    }
//
//    private fun getProfileDataFromFirebase(){
//        Firebase.firestore.collection("users")
//            .document(profileUserId)
//            .get()
//            .addOnSuccessListener {
//                profileUserModel = it.toObject(UserModel::class.java)!!
//                setUI()
//            }
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    fun setUI(){
//        profileUserModel.apply {
//            Glide.with(binding.profilePic).load(profilePic)
//                .apply(RequestOptions().placeholder(R.drawable.icon_account_circle))
//                .circleCrop()
//                .into(binding.profilePic)
//            binding.profileUsername.text = "@$username"
//            if(profileUserModel.followerList.contains(currentUserId))
//                binding.profileBtn.text = "Unfollow"
//            binding.progressBar.visibility = View.INVISIBLE
//            binding.followingCount.text = followingList.size.toString()
//            binding.followerCount.text = followerList.size.toString()
//            Firebase.firestore.collection("videos")
//                .whereEqualTo("uploaderId",profileUserId)
//                .get().addOnSuccessListener {
//                    binding.postCount.text  = it.size().toString()
//                }
//        }
//    }

}
