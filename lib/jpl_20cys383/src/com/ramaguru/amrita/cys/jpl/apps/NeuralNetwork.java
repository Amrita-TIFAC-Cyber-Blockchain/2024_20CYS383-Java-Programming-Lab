package com.ramaguru.amrita.cys.jpl.apps;
import java.util.Arrays;

public class NeuralNetwork {
    private int inputSize;
    private int hiddenSize;
    private int outputSize;
    private double[][] weightsIH;
    private double[][] weightsHO;
    private double[] biasesH;
    private double[] biasesO;
    private double learningRate;
    private int numEpochs;

    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize, double learningRate, int numEpochs) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;
        this.learningRate = learningRate;
        this.numEpochs = numEpochs;

        // Initialize weights and biases
        weightsIH = new double[hiddenSize][inputSize];
        weightsHO = new double[outputSize][hiddenSize];
        biasesH = new double[hiddenSize];
        biasesO = new double[outputSize];

        initializeWeights(weightsIH);
        initializeWeights(weightsHO);
        initializeBiases(biasesH);
        initializeBiases(biasesO);
    }

    private void initializeWeights(double[][] weights) {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                weights[i][j] = Math.random() - 0.5;
            }
        }
    }

    private void initializeBiases(double[] biases) {
        for (int i = 0; i < biases.length; i++) {
            biases[i] = Math.random() - 0.5;
        }
    }

    public double[][] forwardPass(double[][] input) {
        double[][] hiddenLayerOutput = matrixMultiply(weightsIH, input);
        addBias(hiddenLayerOutput, biasesH);
        applyActivationFunction(hiddenLayerOutput);

        double[][] outputLayerOutput = matrixMultiply(weightsHO, hiddenLayerOutput);
        addBias(outputLayerOutput, biasesO);
        applyActivationFunction(outputLayerOutput);

        return outputLayerOutput;
    }

    public void backwardPass(double[][] input, double[][] target) {
        double[][] hiddenLayerOutput = matrixMultiply(weightsIH, input);
        addBias(hiddenLayerOutput, biasesH);
        applyActivationFunction(hiddenLayerOutput);

        double[][] outputLayerOutput = matrixMultiply(weightsHO, hiddenLayerOutput);
        addBias(outputLayerOutput, biasesO);
        applyActivationFunction(outputLayerOutput);

        /*double[][] outputLayerError = subtractFromScalar(1.0, outputLayerOutput);
        multiplyElementWise(outputLayerError, outputLayerOutput);
        multiplyElementWise(outputLayerError, subtractFromScalar(1.0, target));

        double[][] hiddenLayerError = matrixMultiply(transposeMatrix(weightsHO), outputLayerError);
        multiplyElementWise(hiddenLayerError, hiddenLayerOutput);
        multiplyElementWise(hiddenLayerError, subtractFromScalar(1.0, hiddenLayerOutput));

        updateWeights(weightsHO, hiddenLayerOutput, outputLayerError);
        updateWeights(weightsIH, input, hiddenLayerError);

        updateBiases(biasesO, outputLayerError);
        updateBiases(biasesH, hiddenLayerError);*/
    }

    public void updateWeights(double[][] weights, double[][] input, double[][] error) {
        int numRows = weights.length;
        int numCols = weights[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double gradient = 0.0;
                for (int k = 0; k < input[0].length; k++) {
                    gradient += error[i][k] * input[k][j];
                }
                weights[i][j] -= learningRate * gradient;
            }
        }
    }

    public void updateBiases(double[] biases, double[][] error) {
        int numCols = error[0].length;
        for (int i = 0; i < biases.length; i++) {
            double gradient = 0.0;
            for (int j = 0; j < numCols; j++) {
                gradient += error[i][j];
            }
            biases[i] -= learningRate * gradient;
        }
    }

    public double[][] matrixMultiply(double[][] matrix1, double[][] matrix2) {
        int numRows1 = matrix1.length;
        int numCols1 = matrix1[0].length;
        int numRows2 = matrix2.length;
        int numCols2 = matrix2[0].length;

        if (numCols1 != numRows2) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication");
        }

        double[][] result = new double[numRows1][numCols2];

        for (int i = 0; i < numRows1; i++) {
            for (int j = 0; j < numCols2; j++) {
                double sum = 0.0;
                for (int k = 0; k < numCols1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public void addBias(double[][] matrix, double[] biases) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] += biases[i];
            }
        }
    }

    public void applyActivationFunction(double[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = sigmoid(matrix[i][j]);
            }
        }
    }

    public double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static void main(String[] args) {
        int inputSize = 2;
        int hiddenSize = 4;
        int outputSize = 2;
        double learningRate = 0.1;
        int numEpochs = 1000;

        double[][] input = {
                {0, 0, 1, 1},
                {0, 1, 0, 1}
        };
        double[][] target = {
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        NeuralNetwork nn = new NeuralNetwork(inputSize, hiddenSize, outputSize, learningRate, numEpochs);

        for (int epoch = 0; epoch < numEpochs; epoch++) {
            double[][] output = nn.forwardPass(input);
            nn.backwardPass(input, target);

            double loss = calculateLoss(output, target);
            System.out.println("Epoch " + (epoch + 1) + " Loss: " + loss);
        }

        double[][] testInput = {
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        double[][] testOutput = nn.forwardPass(testInput);

        System.out.println("Test Output:");
        for (int i = 0; i < testOutput.length; i++) {
            System.out.println(Arrays.toString(testOutput[i]));
        }
    }

    public static double calculateLoss(double[][] output, double[][] target) {
        int numRows = output.length;
        int numCols = output[0].length;
        double sum = 0.0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                sum += Math.pow(output[i][j] - target[i][j], 2);
            }
        }
        return sum / (2 * numRows);
    }
}
