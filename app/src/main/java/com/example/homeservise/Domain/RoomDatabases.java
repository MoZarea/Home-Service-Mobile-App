package com.example.homeservise.Domain;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.homeservise.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//TODO زود الجدول هنا
@Database(entities = {Category.class, Services.class},version = 1)
public abstract class RoomDatabases extends RoomDatabase {
    private static volatile RoomDatabases instance;

    //TODO اعمل باقي الجداول هنا
    public abstract ServicesDao servicesDao();
    public abstract CategoryDao categoryDao();

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static RoomDatabases getDatabase(final Context context) {
        if (instance == null) {
            synchronized (RoomDatabases.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDatabases.class, "Room_Databases")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return instance;
    }
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
//                // Populate the database in the background.
//                // If you want to start with more words, just add them.
                //Todo ////////////////////////////
                CategoryDao categoryDao = instance.categoryDao();
                categoryDao.deleteAllCategory();
                Category category = new Category("نظافة", R.drawable.broom);
                categoryDao.insert(category);
                Category category1 = new Category("ميكانيكا", R.drawable.mechanic);
                categoryDao.insert(category1);
                Category category2 = new Category("سباكة", R.drawable.plumber);
                categoryDao.insert(category2);
                Category category3 = new Category("كهرباء", R.drawable.electrician);
                categoryDao.insert(category3);
                Category category4 = new Category("غسيل", R.drawable.washing);
                categoryDao.insert(category4);
                Category category5 = new Category("نجارة", R.drawable.carpenter);
                categoryDao.insert(category5);
                Category category6 = new Category("حدائق", R.drawable.gardener);
                categoryDao.insert(category6);
                Category category7 = new Category("طباخ", R.drawable.cooker);
                categoryDao.insert(category7);
                Category category8 = new Category("تعقيم", R.drawable.disinfection);
                categoryDao.insert(category8);
                Category category9 = new Category("بيبي سيتر", R.drawable.babysitter);
                categoryDao.insert(category9);
                //todo////////////////////////////////////////////////////////
                ServicesDao servicesDao = instance.servicesDao();
                servicesDao.deleteAllservices();
                Services services=new Services(R.drawable.electrician,"اعمال الكهرباء ","40 جنية للمعاينة","كهرباء","جميع اعمال صيانة الكهرباء والتركيبات يقدمها افضل الفنيين المحترفين اصحاب الخبرة .\n * نقدم اعمال الصيانة للمنازل والشركات \n* اعمال التأسيس للشقق والفيلات والعمارات \nملاحظات: \n*يتم الاتفاق على السعر بعد اتمام المعاينة \n*يتم حجز العمال الاقرب من المنطقة الاقرب اليك\n*يمكن للعميل شراء الخامات او يقوم الفني بشرائها ومحاسبة العميل عليها \n*السعر غير شامل الخامات  ");
                servicesDao.insert(services);
                Services services1=new Services(R.drawable.plumber,"تأسيس سباكة 1 حمام+1 مطبخ ","2000 جنيه","سباكة","TODO");
                servicesDao.insert(services1);
                Services services2=new Services(R.drawable.carpenter,"نجارة واعمال خشبية ","40 جنية للمعاينة","نجارة","TODO");
                servicesDao.insert(services2);
                Services services3=new Services(R.drawable.broom,"تنظيف الواجهات من الخارج","0 على حسب المعاينه ","نظافة","TODO");
                servicesDao.insert(services3);
                Services services4=new Services(R.drawable.broom,"تنظيف ما بعد التشطيب","14 جنية للمتر","نظافة","TODO");
                servicesDao.insert(services4);
                Services services5=new Services(R.drawable.broom,"تنظيف خزانات ","40 جنية للمعاينة","نظافة","TODO");
                servicesDao.insert(services5);
                Services services6=new Services(R.drawable.broom,"تعقيم وتطهير ضد فيروس كورونا 19","625 جنية","نظافة","TODO");
                servicesDao.insert(services6);
                Services services7=new Services(R.drawable.broom,"نظافة منزلية مميزة Premium","520 جنية","نظافة","TODO");
                servicesDao.insert(services7);
                Services services8=new Services(R.drawable.broom,"اعمال الحدائق واللاندسكيب","40 جنية للمعاينة","اعمال حدائق","TODO");
                servicesDao.insert(services8);
                Services services9=new Services(R.drawable.broom,"تنظيف المنزل للمره الواحدة حتى 170 م","250 جنيه","نظافة","TODO");
                servicesDao.insert(services9);


//

            });
        }
    };

}
