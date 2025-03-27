// Este código foi feito logo após eu estudar sobre perceptron.
// Ele foi feito em Kotlin, visto que eu estava na sala de aula na materia de POO da faculdade.

class Perceptron(qnt_input: Int,
                 learning_rate: Float,
                 bias: Float,
                 epochs: Int) {
    // Atributos
    var weigth = Array(qnt_input) { 0.0 } // Array de pesos
    var qnt_input:Int;
    var learning_rate: Float;
    var bias: Float;
    var epochs: Int;
    // Inicializando os atributos
    init {
        this.qnt_input = qnt_input;
        this.learning_rate = learning_rate;
        this.bias = bias;
        this.epochs = epochs;
    }
    // Função step()
    fun step(somatoria: Double): Int {
        if(somatoria >=0) return 1;
        else return 0;
    }
    // Função de somatória dos inputs
    fun input(inputs: Array<Float>): Double {
        var sum: Double = 0.0
        for (i in 0..<this.qnt_input) {
            sum += inputs[i] * this.weigth[i]
        }
        sum += this.bias
        return sum;
    }
    // Treinando o perceptron..
    fun train(train_data: Array<Array<Float>>, labels: Array<Int>): Unit {
        var sum: Double;
        var y_hat: Int;
        var err: Int;
        for(j in 0..this.epochs){ //Correndo cada época
            for(i in 0..train_data.size) { //Correndo cada dado de treinamento
                // Fazendo a somatória dos inputs
                sum = this.input(train_data[i]);
                // Fazendo a predição | y_hat
                y_hat = this.step(sum);
                // Calculando erro
                err = labels[i] - y_hat;
                // Atualizar o peso
                for(g in 0..<qnt_input){
                    this.weigth[g] += this.learning_rate * err * train_data[i][g];
                }
                // Atualizar a BIAS
                this.bias += this.learning_rate * err;
            }
        }
    }
}