import SwiftUI
import shared

func greet() -> String {
    var number: String? = nil
    let randomizer = CoroutineRandomizer()
    DispatchQueue.global(qos: .utility).async {
        randomizer.generate() { result, error in
            number = result as String?
        }
    }
    return number == nil ? "EMPTY" : number!
}

struct ContentView: View {
    var body: some View {
        Text(greet())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
