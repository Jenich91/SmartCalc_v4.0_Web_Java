#include "calcWrapper.h"

std::string computeExpression(std::string exp, std::string xValue) {
    std::setlocale(LC_NUMERIC,"C");

    s21::Model* model = new s21::Model();

    double x;

    std::stringstream ss;

    if(!xValue.empty() ) {
        std::string tempX = xValue;
        model->SetInputString(tempX);
        x = model->GetResult();
        model->ResetValues();

    }

    model->SetInputString(exp);
    if(x) model->SetX(x);
    double calcResult = model->GetResult();

    std::stringstream().swap(ss); // clean stream
    ss << std::fixed << std::setprecision(7) << calcResult;
    if(std::isnormal(calcResult))
        return ss.str();
    return "NaN";
}

bool validExpression(std::string exp, std::string xValue) {
    if(exp.empty()) return false;
    
    s21::Model* model = new s21::Model();

    if(!xValue.empty() and (!model->IsNormalInputString(xValue) or xValue.find('x')<xValue.length()) ) return false;
    if(model->IsNormalInputString(exp)) return true;

    return false;
}
