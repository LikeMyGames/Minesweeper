#include <iostream>

class Custom{
    public:
        Custom(int x);
        int getX();
    private:
        int x;
};

Custom::Custom(int x) {
    this->x = x;
}

int Custom::getX() {
    return x;
}

int main(){
    Custom obj(10);

    std::cout << obj.getX() << std::endl;
    
    return 0;
}