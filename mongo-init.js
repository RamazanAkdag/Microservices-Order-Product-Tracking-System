// admin veritabanında root kullanıcısını oluştur
db = db.getSiblingDB('admin');
db.createUser({
    user: "root",
    pwd: "example",
    roles: [{ role: "root", db: "admin" }]
});

// product-service veritabanını oluştur ve productUser kullanıcısını ekle
db = db.getSiblingDB('product-service');
db.createUser({
    user: "productUser",
    pwd: "productPass",
    roles: [{ role: "readWrite", db: "product-service" }]
});
